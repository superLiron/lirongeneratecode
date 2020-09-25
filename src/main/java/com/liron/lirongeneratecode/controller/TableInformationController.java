package com.liron.lirongeneratecode.controller;


import com.liron.lirongeneratecode.condition.TableInformationCondition;
import com.liron.lirongeneratecode.dao.TableInformation;
import com.liron.lirongeneratecode.services.GeneratorServices;
import com.liron.lirongeneratecode.services.TableInformationServices;
import com.liron.lirongeneratecode.util.page.Pagination;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "tableInformation")
public class TableInformationController {
    @Autowired
    private TableInformationServices tableInformationServices;
    @Autowired
    private GeneratorServices generatorServices;

    @PostMapping("selectPage")
    public Pagination<TableInformation> selectPage(@RequestBody TableInformationCondition condition) {
        return tableInformationServices.selectPage(condition);
    }

    @GetMapping("selectByTableName")
    public Map<String, String> selectByTableName(@RequestParam(value = "tableName") String tableName) {
        return tableInformationServices.selectByTableName(tableName);
    }
    /**
     * 生成代码
     */
    @PostMapping("generatorCode")
    public void generatorCode( TableInformationCondition condition, HttpServletResponse response) throws IOException {
        if(condition.getTableNameList().isEmpty()){
            return;
        }
        byte[] data = generatorServices.generatorCode(condition.getTableNameList());
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"lironCode.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    /**
     * 生成代码:测试使用
     */
    @GetMapping("generatorCodeTest")
    public void generatorCodeTest(@RequestParam(value = "tableName") String tableName, HttpServletResponse response) throws IOException {
        List<String> tableNames = new ArrayList<>();
        tableNames.add(tableName);
        byte[] data = generatorServices.generatorCode(tableNames);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"lironCode.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}

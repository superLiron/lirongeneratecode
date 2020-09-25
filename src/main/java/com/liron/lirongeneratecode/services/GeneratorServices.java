package com.liron.lirongeneratecode.services;


import com.liron.lirongeneratecode.util.GenUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorServices {
    @Autowired
    private TableInformationServices tableInformationServices;

    @Autowired
    private ColumnsServices columnsServices;

    public byte[] generatorCode(List<String> tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = tableInformationServices.selectByTableName(tableName);
            //查询列信息
            List<Map<String, String>> columns = columnsServices.selectByTableName(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}


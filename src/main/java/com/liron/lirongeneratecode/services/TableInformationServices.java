package com.liron.lirongeneratecode.services;


import com.liron.lirongeneratecode.condition.TableInformationCondition;
import com.liron.lirongeneratecode.dao.TableInformation;
import com.liron.lirongeneratecode.mapper.TableInformationMapper;
import com.liron.lirongeneratecode.util.page.Pagination;
import com.liron.lirongeneratecode.util.page.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableInformationServices {
    @Autowired
    private TableInformationMapper tableInformationMapper;

    public Pagination<TableInformation> selectPage(TableInformationCondition condition) {
        Integer count = tableInformationMapper.getCount(condition);
        RowBounds rowBounds = condition.getRowBounds();
        if (count == 0) {
            return new Pagination(count, rowBounds);
        }
        List<TableInformation> list = tableInformationMapper.selectPage(condition, condition.getRowBounds());
        if (!list.isEmpty()) {
            Pagination page = new Pagination(count, rowBounds);
            page.setData(list);
            return page;
        }
        return new Pagination(count, rowBounds);
    }

    public Map<String, String> selectByTableName(String tableName) {
        TableInformation tableInformation = tableInformationMapper.selectByTableName(tableName);
        Map<String, String> map=new HashMap<>();
        if(tableInformation!=null){
            map.put("tableName",tableInformation.getTableName());
            map.put("engine",tableInformation.getEngine());
            map.put("tableComment",tableInformation.getTableComment());
            map.put("createTime",tableInformation.getCreateTime());
        }
        return map;
    }
}

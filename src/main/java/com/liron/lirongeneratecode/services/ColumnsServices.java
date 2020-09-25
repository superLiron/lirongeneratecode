package com.liron.lirongeneratecode.services;

import com.liron.lirongeneratecode.dao.Columns;
import com.liron.lirongeneratecode.mapper.ColumnsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ColumnsServices {
    @Autowired
    private ColumnsMapper columnsMapper;

    public List<Map<String, String>> selectByTableName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return new ArrayList<>();
        }
        List<Columns> columns = columnsMapper.selectByTableName(tableName);
        List<Map<String, String>> resultList = new ArrayList<>();
        for (Columns column : columns) {
            Map<String, String> map = new HashMap<>();
            map.put("columnName", column.getColumnName());
            map.put("dataType", column.getDataType());
            map.put("columnComment", column.getColumnComment());
            map.put("columnKey", column.getColumnKey());
            map.put("extra", column.getExtra());
            resultList.add(map);
        }
        return resultList;
    }
}

package com.liron.lirongeneratecode.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableInformation implements Serializable {

    private String tableName;
    private String engine;
    private String tableComment;
    private String createTime;
}

package com.liron.lirongeneratecode.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class Columns implements Serializable {
    private String columnName;
    private String dataType;
    private String columnComment;
    private String columnKey;
    private String extra;
}

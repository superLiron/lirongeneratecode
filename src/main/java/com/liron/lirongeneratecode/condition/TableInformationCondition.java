package com.liron.lirongeneratecode.condition;

import com.liron.lirongeneratecode.util.page.PagingCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TableInformationCondition extends PagingCondition implements Serializable {

    private String tableName;
    private String engine;
    private String tableComment;
    private String createTime;
    private String tableNameLike;
    private   List<String> tableNameList;
}

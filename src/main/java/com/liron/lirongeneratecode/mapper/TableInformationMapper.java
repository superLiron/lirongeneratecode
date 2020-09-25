package com.liron.lirongeneratecode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liron.lirongeneratecode.condition.TableInformationCondition;
import com.liron.lirongeneratecode.dao.TableInformation;
import com.liron.lirongeneratecode.util.page.RowBounds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableInformationMapper extends BaseMapper<TableInformation> {

    List<TableInformation> selectPage(TableInformationCondition condition, RowBounds rowBounds);

    int getCount(TableInformationCondition condition);

    TableInformation selectByTableName(String tableName) ;
}

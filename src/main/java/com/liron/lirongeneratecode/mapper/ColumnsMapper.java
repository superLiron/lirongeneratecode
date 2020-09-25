package com.liron.lirongeneratecode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liron.lirongeneratecode.dao.Columns;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ColumnsMapper extends BaseMapper<Columns> {

    List<Columns> selectByTableName(String tableName);
}

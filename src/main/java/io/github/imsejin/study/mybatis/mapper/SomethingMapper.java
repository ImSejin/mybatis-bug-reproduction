package io.github.imsejin.study.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import io.github.imsejin.study.mybatis.domain.Code;
import io.github.imsejin.study.mybatis.jdbc.mybatis.CodeTypeHandler;

@Mapper
public interface SomethingMapper {

    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "code", column = "CODE", typeHandler = CodeTypeHandler.class),
    })
    @Select("SELECT * FROM SOMETHING WHERE CODE = #{code}")
    List<Map<String, Object>> findByCode(Code code);

}

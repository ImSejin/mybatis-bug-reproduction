package io.github.imsejin.study.mybatis.mapper;

import io.github.imsejin.study.mybatis.domain.Code;
import io.github.imsejin.study.mybatis.entity.Something;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SomethingMapper {

    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "code", column = "CODE"),
    })
    @Select("SELECT * FROM SOMETHING WHERE CODE = #{code}")
    List<Something> findByCode(Code code);

}

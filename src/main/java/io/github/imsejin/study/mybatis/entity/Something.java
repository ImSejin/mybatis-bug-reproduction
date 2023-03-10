package io.github.imsejin.study.mybatis.entity;

import io.github.imsejin.study.mybatis.domain.Code;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Something {

    private Long id;

    private String name;

    private Code code;

}

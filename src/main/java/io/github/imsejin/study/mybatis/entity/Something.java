package io.github.imsejin.study.mybatis.entity;

import io.github.imsejin.study.mybatis.domain.Code;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Something {

    private Long id;

    private String name;

    private Code code;

}

package io.github.imsejin.study.mybatis.entity;

import io.github.imsejin.study.mybatis.domain.Code;
import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Something {

    private Long id;

    private String name;

    private Code code;

    @Builder
    public Something(Long id, String name, Code code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

}

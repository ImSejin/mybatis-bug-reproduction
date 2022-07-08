package io.github.imsejin.study.mybatis.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AlphaCode implements Code {

    private static final Pattern PATTERN = Pattern.compile("^A[0-9]{9}$");

    @EqualsAndHashCode.Include
    private final String value;

    public AlphaCode(String value) {
        if (!canInstantiate(value)) {
            throw new IllegalArgumentException("Invalid AlphaCode.value: " + value);
        }

        this.value = value;
    }

    public static boolean canInstantiate(String value) {
        return StringUtils.hasLength(value) && value.length() == 10 && PATTERN.matcher(value).matches();
    }

}

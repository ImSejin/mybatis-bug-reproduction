package io.github.imsejin.study.mybatis.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BetaCode implements Code {

    private static final Pattern PATTERN = Pattern.compile("^B[0-9]{9}$");

    @EqualsAndHashCode.Include
    private final String value;

    public BetaCode(String value) {
        if (!canInstantiate(value)) {
            throw new IllegalArgumentException("Invalid BetaCode.value: " + value);
        }

        this.value = value;
    }

    public static boolean canInstantiate(String value) {
        return StringUtils.hasLength(value) && value.length() == 10 && PATTERN.matcher(value).matches();
    }

}

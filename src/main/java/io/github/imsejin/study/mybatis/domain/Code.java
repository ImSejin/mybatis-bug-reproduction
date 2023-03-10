package io.github.imsejin.study.mybatis.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Code {

    private static final Pattern PATTERN = Pattern.compile("^[AB][0-9]{9}$");

    private final String value;

    private final CodeType type;

    public Code(String value) {
        super();
        if (value == null || !PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid Code value: " + value);
        }
        this.value = value;
        if (value.startsWith("A")) {
            this.type = CodeType.ALPHA;
        } else {
            this.type = CodeType.BETA;
        }
    }

    public String getValue() {
        return this.value;
    }

    public CodeType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Code)) {
            return false;
        }
        Code other = (Code) obj;
        return type == other.type && Objects.equals(value, other.value);
    }

    enum CodeType {
        ALPHA, BETA
    }
}

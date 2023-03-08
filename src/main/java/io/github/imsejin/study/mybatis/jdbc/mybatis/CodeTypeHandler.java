package io.github.imsejin.study.mybatis.jdbc.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import io.github.imsejin.study.mybatis.domain.AlphaCode;
import io.github.imsejin.study.mybatis.domain.BetaCode;
import io.github.imsejin.study.mybatis.domain.Code;

@MappedTypes({BetaCode.class, AlphaCode.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class CodeTypeHandler extends BaseTypeHandler<Code> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Code parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Code getNullableResult(ResultSet rs, String columnName) throws SQLException {
        var string = rs.getString(columnName);
        return string == null ? null : resolve(string);
    }

    @Override
    public Code getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        var string = rs.getString(columnIndex);
        return string == null ? null : resolve(string);
    }

    @Override
    public Code getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        var string = cs.getString(columnIndex);
        return string == null ? null : resolve(string);
    }

    private static Code resolve(String value) {
        if (AlphaCode.canInstantiate(value)) return new AlphaCode(value);
        if (BetaCode.canInstantiate(value)) return new BetaCode(value);
        return null;
    }

}

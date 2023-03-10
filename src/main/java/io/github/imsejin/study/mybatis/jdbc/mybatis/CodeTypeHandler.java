package io.github.imsejin.study.mybatis.jdbc.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import io.github.imsejin.study.mybatis.domain.Code;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class CodeTypeHandler extends BaseTypeHandler<Code> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Code parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Code getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return resolve(rs.getString(columnName));
    }

    @Override
    public Code getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return resolve(rs.getString(columnIndex));
    }

    @Override
    public Code getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return resolve(cs.getString(columnIndex));
    }

    private static Code resolve(String value) {
        if (value == null) {
            return null;
        }
        return new Code(value);
    }

}

package io.github.imsejin.study.mybatis.jdbc.mybatis;

import io.github.imsejin.study.mybatis.domain.AlphaCode;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(AlphaCode.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class AlphaCodeTypeHandler extends BaseTypeHandler<AlphaCode> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AlphaCode parameter, JdbcType jdbcType)
            throws SQLException {
        throw new RuntimeException("NEVER THROW");
    }

    @Override
    public AlphaCode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        throw new RuntimeException("NEVER THROW");
    }

    @Override
    public AlphaCode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        throw new RuntimeException("NEVER THROW");
    }

    @Override
    public AlphaCode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        throw new RuntimeException("NEVER THROW");
    }

}

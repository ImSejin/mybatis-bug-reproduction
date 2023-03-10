package io.github.imsejin.study.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;

import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import io.github.imsejin.study.mybatis.domain.Code;
import io.github.imsejin.study.mybatis.mapper.SomethingMapper;

/**
 * @see DefaultParameterHandler#setParameters(PreparedStatement)
 */
@MybatisTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CodeTypeHandlerTest {

    @Autowired
    private SomethingMapper somethingMapper;

    @Test
    void testAlphaCode() {
        // given
        var alphaCode = new Code("A194835601");

        // when
        var somethings = somethingMapper.findByCode(alphaCode);
        assertNotNull(somethings);

        var something = somethings.get(0);
        assertEquals(1L, something.getId());
        assertEquals("1dbe750e346d4c579ad900eb29f981b4", something.getName());
        assertEquals(alphaCode, something.getCode());
    }

    @Test
    void testBetaCode() {
        // given
        var betaCode = new Code("B834593849");

        // when
        var somethings = somethingMapper.findByCode(betaCode);
        assertNotNull(somethings);

        var something = somethings.get(0);
        assertEquals(6L, something.getId());
        assertEquals("e0a037a8f58b409f80008da7c5019df7", something.getName());
        assertEquals(betaCode, something.getCode());
    }

}

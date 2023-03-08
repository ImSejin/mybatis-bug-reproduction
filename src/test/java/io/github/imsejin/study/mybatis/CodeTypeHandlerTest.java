package io.github.imsejin.study.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import io.github.imsejin.study.mybatis.domain.AlphaCode;
import io.github.imsejin.study.mybatis.domain.BetaCode;
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
        var alphaCode = new AlphaCode("A194835601");

        // when
        var somethings = somethingMapper.findByCode(alphaCode);
        assertNotNull(somethings);

        Map<String, Object> map = somethings.get(0);
        assertEquals(1L, map.get("id"));
        assertEquals("1dbe750e346d4c579ad900eb29f981b4", map.get("name"));
        assertEquals(alphaCode, map.get("code"));
    }

    @Test
    void testBetaCode() {
        // given
        var betaCode = new BetaCode("B834593849");

        // when
        var somethings = somethingMapper.findByCode(betaCode);

        Map<String, Object> map = somethings.get(0);
        assertEquals(6L, map.get("id"));
        assertEquals("e0a037a8f58b409f80008da7c5019df7", map.get("name"));
        assertEquals(betaCode, map.get("code"));
        assertNotNull(somethings);
    }

}

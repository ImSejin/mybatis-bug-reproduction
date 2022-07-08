package io.github.imsejin.study.mybatis;

import io.github.imsejin.study.mybatis.domain.AlphaCode;
import io.github.imsejin.study.mybatis.domain.BetaCode;
import io.github.imsejin.study.mybatis.entity.Something;
import io.github.imsejin.study.mybatis.mapper.SomethingMapper;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.MyBatisSystemException;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.sql.PreparedStatement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

        // then
        assertThat(somethings)
                .isNotNull()
                .isNotEmpty()
                .doesNotContainNull()
                .hasSize(1)
                .containsOnly(Something.builder()
                        .id(1L)
                        .name("1dbe750e346d4c579ad900eb29f981b4")
                        .code(alphaCode)
                        .build());
    }

    @Test
    void testBetaCode() {
        // given
        var betaCode = new BetaCode("B834593849");

        // expect
        assertThatExceptionOfType(MyBatisSystemException.class)
                .isThrownBy(() -> somethingMapper.findByCode(betaCode))
                .withMessageStartingWith("nested exception is org.apache.ibatis.reflection.ReflectionException: " +
                        "There is no getter for property named 'code'");
    }

}

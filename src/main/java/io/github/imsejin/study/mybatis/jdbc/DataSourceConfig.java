package io.github.imsejin.study.mybatis.jdbc;

import io.github.imsejin.study.mybatis.MainApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@MapperScan(
        basePackageClasses = MainApplication.class,
        markerInterface = Mapper.class,
        sqlSessionTemplateRef = DataSourceConfig.SQL_SESSION_TEMPLATE_BEAN_NAME,
        lazyInitialization = "true"
)
@Configuration
public class DataSourceConfig {

    static final String SQL_SESSION_TEMPLATE_BEAN_NAME = "sqlSessionTemplate";

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    static DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    static SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        return factoryBean.getObject();
    }

    @Bean(SQL_SESSION_TEMPLATE_BEAN_NAME)
    @Primary
    static SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}

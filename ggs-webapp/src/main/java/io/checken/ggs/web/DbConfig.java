/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package io.checken.ggs.web;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 *
 * @author wungmc 2017/6/23.
 */
@Configuration
public class DbConfig {
    static final Logger LOGGER = LoggerFactory.getLogger(DbConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        DruidDataSource dataSource = dataSource();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("io.checken.ggs.dal.model");
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DruidDataSource dataSource = dataSource();
        return new DataSourceTransactionManager(dataSource);
    }

}

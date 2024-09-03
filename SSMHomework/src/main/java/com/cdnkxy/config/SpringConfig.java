package com.cdnkxy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({MyBatisConfig.class,JdbcConfig.class})
@ComponentScan(value="com.cdnkxy.service")
@EnableTransactionManagement
public class SpringConfig {
	
	@Bean("transactionManager")
	public DataSourceTransactionManager getDataSourceTxManager(@Autowired DataSource dataSource) {
		DataSourceTransactionManager dsm=new DataSourceTransactionManager();
		dsm.setDataSource(dataSource);
		return dsm;
	}
}

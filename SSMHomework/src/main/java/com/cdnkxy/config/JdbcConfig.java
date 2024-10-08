package com.cdnkxy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
	@Value("${jdbc.driverClassName}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		DruidDataSource ds=new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

}

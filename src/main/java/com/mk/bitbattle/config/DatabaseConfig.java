package com.mk.bitbattle.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DatabaseConfig {
	
	@Value("${jdbc.driverClassName}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	
	@Bean(destroyMethod = "")
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		return namedParameterJdbcTemplate;
	}	
}

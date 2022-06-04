package com.learn.aptx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"com.learn.aptx.dao"})
public class PersistanceConfig {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = null;
		
		dataSource = new DriverManagerDataSource(env.getProperty("db.url"), env.getProperty("db.username"), env.getProperty("db.password"));
		dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager platFormTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}

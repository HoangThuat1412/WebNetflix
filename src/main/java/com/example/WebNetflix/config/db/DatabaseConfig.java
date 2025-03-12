package com.example.WebNetflix.config.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.example.WebNetflix.config.AES;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	@Value("${db.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${db.datasource.url}")
	private String urlDB;

	@Value("${db.datasource.username}")
	private String userName;

	@Value("${db.datasource.password}")
	private String password;
	
	private String secretKey = "Aa@123456";
	

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setJdbcUrl(AES.decrypt(urlDB, secretKey));
//		hikariConfig.setDriverClassName(AES.decrypt(driverClassName, secretKey));
//		hikariConfig.setUsername(AES.decrypt(userName, secretKey));
//		hikariConfig.setPassword(AES.decrypt(password, secretKey));
		
		hikariConfig.setJdbcUrl(urlDB);
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setUsername(userName);
		hikariConfig.setPassword(password);
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

		return hikariDataSource;
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/hoangvanthuat/WebNetFlix/mapper/sql/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
}

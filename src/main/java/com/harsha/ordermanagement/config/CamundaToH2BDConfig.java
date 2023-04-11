package com.harsha.ordermanagement.config;
//package com.ey.ordermanagement.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//public class CamundaToH2BDConfig {
//	
//	@Primary
//	@Bean(name="camundaBpmDataSource")
//	@ConfigurationProperties(prefix="spring.camunda.datasource")
//	public DataSource secondaryDataSource() {
//	  return DataSourceBuilder.create().build();
//	}
//	
//	@Bean
//	public PlatformTransactionManager transactionManager
//		(@Qualifier("camundaBpmDataSource") DataSource dataSource) {
//	  return new DataSourceTransactionManager(dataSource);
//	}
//
//}

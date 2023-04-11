package com.harsha.ordermanagement.config;
package com.ey.ordermanagement.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "customerEntityManagerFactory",
		transactionManagerRef = "customerTransactionManager",
		basePackages = {
				"com.ey.ordermanagement.customerdata.repository"
		}
)
public class CustomerDataToMySqlDBConfig {

	@Bean(name = "userDataSource")
	@ConfigurationProperties(prefix = "spring.customerdata.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "customerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return builder.dataSource(dataSource)
					  .properties(properties)
					  .packages("com.ey.ordermanagement.model")
					  .persistenceUnit("CustomerData")
					  .build();
	}
	
	@Bean(name = "customerTransactionManager")
	public PlatformTransactionManager customerTransactionManager(@Qualifier("customerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}

package com.rest.automation.admin.rest.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@PropertySource("file:${restautomation.server.home}/config/restautomation-app.properties")
@EnableJpaRepositories(entityManagerFactoryRef="restautomationManagerFactory",basePackages={"com.rest.automation.admin.da.repository"})
public class RestAutomationSchemaConfiguration {

	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public DataSource restAutomationDataSource() {
		return DataSourceBuilder.create()
				.username(env.getProperty("restautomation.db.username"))
				.password(env.getProperty("restautomation.db.password"))
				.url(env.getProperty("restautomation.db.url"))
				.driverClassName(env.getProperty("restautomation.db.driverClassName"))
				.build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean restautomationManagerFactory(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean bean = builder.dataSource(restAutomationDataSource()).packages("com.rest.automation.admin.da.domain").build();
		bean.setJpaProperties(this.additionalProperties());
		return bean;
	}

	private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.setProperty("hibernate.show_sql", "false");
        return properties;
	}
}

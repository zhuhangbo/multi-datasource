package dev.local.multidatasource.configuration.datasource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = "classpath:datasource.properties", encoding = "UTF-8")
public class DataSourceConfiguration {
	@Bean("person")
	@ConfigurationProperties(prefix = "spring.datasource.person")
	public HikariDataSource personDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean("people")
	@ConfigurationProperties(prefix = "spring.datasource.people")
	public HikariDataSource peopleDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean
	@Primary
	public DynamicDataSource dataSource( //
			@Qualifier("person") HikariDataSource personDataSource, //
			@Qualifier("people") HikariDataSource peopleDataSource) {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceEnum.PERSON_DS, personDataSource);
		targetDataSources.put(DataSourceEnum.PEOPLE_DS, peopleDataSource);
		dynamicDataSource.setTargetDataSources(targetDataSources);
		
		dynamicDataSource.setDefaultTargetDataSource(personDataSource);

		return dynamicDataSource;
	}
}

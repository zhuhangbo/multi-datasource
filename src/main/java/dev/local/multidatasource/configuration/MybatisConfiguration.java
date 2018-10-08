package dev.local.multidatasource.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import dev.local.multidatasource.configuration.datasource.DynamicDataSource;

@Configuration
@MapperScan("dev.local.multidatasource.dao.mapper")
public class MybatisConfiguration {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations( //
				new PathMatchingResourcePatternResolver().getResources("mapper/*.xml"));

		return sqlSessionFactory.getObject();
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}

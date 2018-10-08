package dev.local.multidatasource.configuration.datasource;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspects {
	private final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspects.class);

	@Before(value = "@annotation(dev.local.multidatasource.configuration.datasource.TargetDataSource)")
	public void changeDataSource(JoinPoint jp) {
		LOGGER.info("方法 {} 调用了该数据源切换方法... ", jp.getSignature().getName());

		Arrays.stream(jp.getTarget().getClass().getMethods()) //
				.filter(method -> method.getName().equals(jp.getSignature().getName())) //
				.filter(method -> method.getParameters().length == jp.getArgs().length) //
				.findFirst() //
				.map(method -> method.getDeclaredAnnotation(TargetDataSource.class)) //
				.ifPresent(dataSource -> DataSourceHolder.setKeyHolder(dataSource.value()));
	}

	@After(value = "@annotation(dev.local.multidatasource.configuration.datasource.TargetDataSource)")
	public void clearDataSource(JoinPoint jp) {
		DataSourceHolder.clearKeyholder();
	}
}

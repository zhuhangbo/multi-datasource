package dev.local.multidatasource.configuration.datasource;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
public @interface TargetDataSource {
	DataSourceEnum value() default DataSourceEnum.PERSON_DS;
}

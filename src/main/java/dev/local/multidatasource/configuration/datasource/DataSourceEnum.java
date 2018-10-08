package dev.local.multidatasource.configuration.datasource;

import java.util.Arrays;

public enum DataSourceEnum {
	PERSON_DS("person"), //
	PEOPLE_DS("people");
	
	private final String code;

	private DataSourceEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static DataSourceEnum getByCode(String code) {
		return Arrays.stream(values()) //
				.filter(dsEnum -> dsEnum.getCode().equals(code)) //
				.findFirst() //
				.orElseThrow(() -> new RuntimeException(String.format("%s 是未定义的DataSource类型", code)));
	}
}

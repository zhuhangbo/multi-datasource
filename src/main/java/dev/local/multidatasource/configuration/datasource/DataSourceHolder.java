package dev.local.multidatasource.configuration.datasource;

public class DataSourceHolder {
	private static ThreadLocal<DataSourceEnum> keyHolder = new ThreadLocal<>();

	public static DataSourceEnum getKeyHolder() {
		return keyHolder.get();
	}

	public static void setKeyHolder(DataSourceEnum value) {
		keyHolder.set(value);
	}

	public static void clearKeyholder() {
		keyHolder.remove();
	}
}

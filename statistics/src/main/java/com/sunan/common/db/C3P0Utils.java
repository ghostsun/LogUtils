package com.sunan.common.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class C3P0Utils {

	private static final String JDBC_DRIVER = "driverClass";
	private static final String JDBC_URL = "jdbcUrl";

	private static DataSource ds;
	/**
	 * 初始化连接池代码块
	 */
	static {
		initDBSource();
	}

	/**
	 * 初始化c3p0连接池
	 */
	private static final void initDBSource() {
		Properties c3p0Pro = new Properties();
//		try {
//			// 加载配置文件
//			c3p0Pro.load(new FileInputStream("./bin/c3p0.properties"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		c3p0Pro.put("driverClass", "com.mysql.jdbc.Driver");
		c3p0Pro.put("jdbcUrl", "jdbc:mysql://172.16.8.21:3306/logs");
		c3p0Pro.put("user", "aweb");
		c3p0Pro.put("password", "aweb");
		c3p0Pro.put("minPoolSize", "3");
		c3p0Pro.put("maxPoolSize", "10");

		String drverClass = c3p0Pro.getProperty(JDBC_DRIVER);
		if (drverClass != null) {
			try {
				// 加载驱动类
				Class.forName(drverClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		Properties jdbcpropes = new Properties();
		Properties c3propes = new Properties();
		for (Object key : c3p0Pro.keySet()) {
			String skey = (String) key;
			if (skey.startsWith("c3p0.")) {
				c3propes.put(skey, c3p0Pro.getProperty(skey));
			} else {
				jdbcpropes.put(skey, c3p0Pro.getProperty(skey));
			}
		}

		try {
			// 建立连接池
			DataSource unPooled = DataSources.unpooledDataSource(
					c3p0Pro.getProperty(JDBC_URL), jdbcpropes);
			ds = DataSources.pooledDataSource(unPooled, c3propes);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return 数据连接对象
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException {
		final Connection conn = ds.getConnection();
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		return conn;
	}
	
	public static DataSource getDateSource(){
		return ds;
	}
}

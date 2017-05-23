package com.simple.gofirst.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectSerivce {

	Connection conn = null;
	// /Connection newConn = null;

	Statement stmt = null;
	// /Statement newStmt = null;
	int rs;

	String url = null;
	// String urlNew=null;

	String user = null;
	String password = null;

	String sql = null;

	/// mysql 数据库初始化
	/*
	 * void Init() {
	 * 
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver"); // 加载mysq驱动 } catch
	 * (ClassNotFoundException e) { System.out.println("驱动加载错误");
	 * e.printStackTrace();// 打印出错详细信息 } try {
	 * 
	 * /// 本地 url = "jdbc:mysql://localhost/mts_sync? user=root&password=root"
	 * ;// 简单写法：url user = "root"; password = "root";
	 * 
	 * conn = DriverManager.getConnection(url, user, password); // newConn =
	 * DriverManager.getConnection(urlNew, user, password); } catch
	 * (SQLException e) { System.out.println("数据库链接错误"); e.printStackTrace(); }
	 * 
	 * }
	 */

	/// oracle的初始化
	public void Init() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			System.out.println("不存在oracle驱动jar包");
			e1.printStackTrace();
		}

		try {
			/// 本地
			url = "jdbc:oracle:thin:@192.168.1.176:1521:ORCL";// 简单写法：url
			user = "gepm";
			password = "gepm";

			conn = DriverManager.getConnection(url, user, password);
			// newConn = DriverManager.getConnection(urlNew, user, password);
		} catch (SQLException e) {
			System.out.println("数据库连接参数错误，请检查URL");
			System.out.println("数据库连接参数错误，请检查用户名，密码");
			e.printStackTrace();
		}

	}

	

	// ///关闭数据库连接
	public boolean closedb() {
		// 关闭数据库
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

			// if (newStmt != null) {
			// newStmt.close();
			// newStmt = null;
			// }
			// if (newConn != null) {
			// newConn.close();
			// newConn = null;
			// }
		} catch (Exception e) {
			System.out.println("数据库关闭错误");
			e.printStackTrace();
		}

		return true;

	}


	public ResultSet getModulesResultSet(String sql) throws SQLException {
		
		Init();
		stmt = conn.createStatement();

		// 执行sql语句
		ResultSet queryModuleSet = stmt.executeQuery(sql);

		/*
		 * while (querySet.next()) { System.out.println("name: " +
		 * querySet.getString("module_no")); }
		 */
		
	
		//System.out.println(mapResult.get("GC"));
		return queryModuleSet;
	}

}


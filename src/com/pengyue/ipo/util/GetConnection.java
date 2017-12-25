package com.pengyue.ipo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcall";
	private String username = "sjcj";
	private String pwd = "sjcj";

	public Connection getConn() {

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAllpre(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != pst) {
				pst.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAllsta(Connection conn, Statement st, ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != st) {
				st.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

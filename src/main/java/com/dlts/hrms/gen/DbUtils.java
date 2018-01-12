package com.dlts.hrms.gen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;

public class DbUtils {

	public static List<Table> getTables() {
		List<Table> tables = Lists.newArrayList();

		String sql = "SELECT TABLE_NAME,TABLE_COMMENT from information_schema.`TABLES` where TABLE_SCHEMA = 'hrms'";

		Connection conn = getConn();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Table t = new Table();
				t.name = rs.getString("TABLE_NAME");
				t.comment = rs.getString("TABLE_COMMENT");
				tables.add(t);
			}

			closePstmt(pstmt, rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}

		return tables;
	}

	public static List<Column> getColumns(String tableName) {
		List<Column> tables = Lists.newArrayList();

		String sql = "SELECT COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE from information_schema.`COLUMNS` where TABLE_SCHEMA = 'hrms' and TABLE_NAME = '"
				+ tableName + "'";

		Connection conn = getConn();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Column t = new Column();
				t.name = rs.getString("COLUMN_NAME");
				t.comment = rs.getString("COLUMN_COMMENT");
				t.type = rs.getString("DATA_TYPE");
				tables.add(t);
			}

			closePstmt(pstmt, rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}

		return tables;
	}

	public static Connection getConn() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hrms?useUnicode=true&characterEncoding=utf-8", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePstmt(PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

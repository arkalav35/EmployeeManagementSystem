package com.empApp.empApp.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

	public Connection getMySQLConnection() throws Exception {

		Connection conn = null;

		try {

			ResourceBundle bundle = ResourceBundle.getBundle("application.properties");

			Class.forName(bundle.getString("spring.datasource.driver-class-name"));

			String url = bundle.getString("spring.datasource.url");

			String username = bundle.getString("spring.datasource.username");

			String password = bundle.getString("spring.datasource.password");

			System.out.println(username);

			conn = DriverManager.getConnection(url, username,

					password);

		} catch (SQLException e) {

			conn = null;

			e.printStackTrace();

			throw e;

		} catch (Exception e) {

			conn = null;

			e.printStackTrace();

			throw e;

		}

		return conn;

	}

}

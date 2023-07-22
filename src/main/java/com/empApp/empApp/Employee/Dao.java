package com.empApp.empApp.Employee;

import java.sql.Connection;

import org.springframework.stereotype.Component;

@Component
public class Dao {

	public boolean addEmployee(Employee e) {
		boolean success = false;

		Connection conn = null;
		try {
			conn = new DBConnection().getMySQLConnection();
			success = true;
			System.out.println(conn);
		} catch (Exception e1) {

			conn = null;

			e1.printStackTrace();
			success = false;

		}

		return success;

	}

	public Connection check() throws Exception {
		Connection conn = new DBConnection().getMySQLConnection();
		return conn;

	}

}

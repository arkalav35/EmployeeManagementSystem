package com.empApp.empApp.SQLConnection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empApp.empApp.Employee.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}

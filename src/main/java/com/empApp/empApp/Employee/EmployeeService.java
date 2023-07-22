package com.empApp.empApp.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class EmployeeService {

	private static List<Employee> employee = new ArrayList<>();
	private static int empCount = 100;

	static {
		employee.add(new Employee(++empCount, "ABC", "DEF", "96789", "Hyderabad", "Male"));
		employee.add(new Employee(++empCount, "GHI", "JKL", "12345", "Chennai", "Male"));
		employee.add(new Employee(++empCount, "MNO", "PQR", "76543", "Mumbai", "Female"));
	}

	public List<Employee> getData() {
		return employee;
	}

	public void addEmployee(String firstname, String lastname, String phno, String city, String gender) {
		Employee emplo = new Employee(++empCount, firstname, lastname, phno, city, gender);
		boolean add_emo = new Dao().addEmployee(emplo);
		employee.add(emplo);
	}

	public void DeleteByID(int id) {

		Predicate<? super Employee> predicate = emplo -> emplo.getId() == id;
		employee.removeIf(predicate);
	}

	public Employee findByID(int id) {

		Predicate<? super Employee> predicate = emplo -> emplo.getId() == id;
		Employee e1 = employee.stream().filter(predicate).findFirst().get();
		return e1;
	}

	public void UpdateEmployee(@Valid Employee employee2) {

		DeleteByID(employee2.getId());
		employee.add(employee2);

	}

}

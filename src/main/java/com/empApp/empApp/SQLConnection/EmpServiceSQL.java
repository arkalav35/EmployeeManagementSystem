package com.empApp.empApp.SQLConnection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empApp.empApp.Employee.Employee;

@Service
public class EmpServiceSQL {

	@Autowired
	private EmpRepository empRepository;

	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}

	public Employee updateEmp(int id, Employee emp) {
		Employee existingEmp = empRepository.findById(id).orElse(null);
		if (existingEmp != null) {
			existingEmp.setFirstname(emp.getFirstname());
			existingEmp.setLastname(emp.getLastname());
			existingEmp.setPhno(emp.getPhno());
			existingEmp.setCity(emp.getCity());
			existingEmp.setGender(emp.getGender());
			return empRepository.save(existingEmp);
		}
		return null;
	}

	public void DeleteByID(int id) {
		empRepository.deleteById(id);
	}

}

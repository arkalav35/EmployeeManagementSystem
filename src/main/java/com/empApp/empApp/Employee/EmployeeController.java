package com.empApp.empApp.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Dao dao;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String WelcomePage(ModelMap model) {
		model.put("username", "admin");
		return "welcome";
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String GoToForm(ModelMap model) throws Exception {
		Employee employee = new Employee(100, "firstname", "lastname", "+91 xxxxxxxxxx", "Select your city...",
				"gender");
		employeeService.addEmployee(null, null, null, null, null);
		System.out.println(dao.check());
		model.put("employee", employee);

		return "form";
	}

	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String GoToEmployeeList(ModelMap model, @Valid Employee employee, BindingResult result) {

		if (result.hasErrors()) {
			return "form";
		}

//		employeeService.addEmployee(employee.getFirstname(), employee.getLastname(), employee.getPhno(),
//				employee.getCity(), employee.getGender());
		return "redirect:employee-list";
	}

	@RequestMapping("employee-list")
	public String listAllEmployee(ModelMap model) {

		List<Employee> emp = employeeService.getData();
		model.addAttribute("emp", emp);
		return ("listEmployee");

	}

	@RequestMapping("delete-employee")
	public String DeleteEmployee(@RequestParam int id) {

		employeeService.DeleteByID(id);

		return ("redirect:employee-list");
	}

	@RequestMapping(value = "update-employee", method = RequestMethod.GET)
	public String showUpdateEmployeePage(@RequestParam int id, ModelMap model) {

		Employee employee = employeeService.findByID(id);
		model.addAttribute("employee", employee);
		return ("form");
	}

	@RequestMapping(value = "update-employee", method = RequestMethod.POST)
	public String UpdateEmployee(@Valid Employee employee, ModelMap model, BindingResult result) {

		if (result.hasErrors()) {
			return "form";
		}
		employeeService.UpdateEmployee(employee);
		return "redirect:employee-list";
	}

}

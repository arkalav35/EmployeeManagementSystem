package com.empApp.empApp.SQLConnection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empApp.empApp.Employee.Employee;

@Controller
public class EmpControllerSQL {

	@Autowired
	private EmpServiceSQL empService;

	@Autowired
	private EmpRepository empRepository;

	@GetMapping("/employee")
	public String getAllEmployee(ModelMap model) {
//		return empRepository.findAll();

		List<Employee> employee = empRepository.findAll();
		model.addAttribute("employee", employee);
		return "DataTable";
	}

	@GetMapping("/register")
	public String showRegistrationForm(ModelMap model) {
		model.addAttribute("employee", new Employee());
		return "AddEmp";
	}

	@PostMapping("/register")
	public String processRegistrationForm(@ModelAttribute Employee employee, ModelMap model) {
		empRepository.save(employee);
		return "redirect:employee";
	}

	@GetMapping("/update")
	public String showUpdateEmployeePage(@RequestParam int id, ModelMap model) {

		Employee employee = empRepository.findById(id).orElse(null);
		model.addAttribute("employee", employee);
		return ("form");
	}

	@PostMapping("/update")
	public String updateRecord(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String phno, @RequestParam String city, @RequestParam String gender) {
		Employee employee = empRepository.findById(id).orElse(null);
		if (employee != null) {
			employee.setFirstname(firstname);
			employee.setLastname(lastname);
			employee.setPhno(phno);
			employee.setCity(city);
			employee.setGender(gender);
			empRepository.save(employee);
			System.out.println(employee.toString());
			return "redirect:employee";
		}
		return "redirect:/error";
	}

	@RequestMapping("/remove")
	public String DeleteEmployee(@RequestParam int id) {
		empService.DeleteByID(id);
		return "redirect:/employee";
	}
}

package com.eidiko.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add")
	public String addEmployee_Details(Model model) {
		model.addAttribute("employee",new Employee());
		return "addEmployeeForm";
	}
	
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		Employee emp = employeeService.saveEmployee(employee);
		
		if(emp != null) {
			model.addAttribute("status", "success");
			model.addAttribute("empId", emp.getEmpId());
		} else {
			model.addAttribute("status", "failure");
		}
		return "addEmployeeResult";
	}
	
	/*@GetMapping("/update")
	public String updateEmployee(Model model) {
		
	}*/
	
	/*public String deleteEmployee() {
		
	}*/
	
	@GetMapping("/search")
	public String searchEmployeeById(Model model) {
		model.addAttribute("searchRequest", new Employee());
		return "searchEmployeeById";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@ModelAttribute("searchRequest") Employee employee, Model model) {
		Employee emp = employeeService.getEmployee(employee.getEmpId()).get();
		model.addAttribute("employee", emp);
		return "EmployeeDetails";
	}

}

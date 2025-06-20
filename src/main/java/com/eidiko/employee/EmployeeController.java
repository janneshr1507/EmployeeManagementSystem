package com.eidiko.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
	
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
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
				
		return "home";
	}

}

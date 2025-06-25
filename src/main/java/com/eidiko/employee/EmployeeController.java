package com.eidiko.employee;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/update")
	public String updateEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "updateEmployee";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		boolean updateStatus = employeeService.updateEmployee(employee);
		
		if(updateStatus) {
			model.addAttribute("status", "success");
			model.addAttribute("empId", employee.getEmpId());
		} else {
			model.addAttribute("status", "failure");
		}
		return "updateEmployeeResult";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee_Details(Model model) {
		model.addAttribute("employee", new Employee());
		return "deleteEmployee";
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		int empId = employee.getEmpId();
		boolean deleteStatus = employeeService.deleteEmployee(empId);
		
		if(deleteStatus) {
			model.addAttribute("status", "success");
	        model.addAttribute("empId", empId);
		} else {
			model.addAttribute("status", "failure");
		}
		return "deleteStatus";
	}
	
	@GetMapping("/search")
	public String searchEmployeeById(Model model) {
		model.addAttribute("searchRequest", new Employee());
		return "searchEmployeeById";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@ModelAttribute("searchRequest") Employee employee, Model model) {
	    Optional<Employee> optionalEmp = employeeService.getEmployee(employee.getEmpId());

	    if (optionalEmp.isPresent()) {
	        model.addAttribute("employee", optionalEmp.get());
	    } else {
	        model.addAttribute("employee", null);
	    }

	    return "EmployeeDetails";
	}

	
	@GetMapping("/all")
	public String allEmployess(Model model) {
		List<Employee> list = employeeService.getAllEmployees();
		model.addAttribute("employeeList", list);
		return "allEmployees";
	}

}

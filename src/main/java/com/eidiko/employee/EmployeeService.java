package com.eidiko.employee;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
	this.employeeRepository = employeeRepository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Optional<Employee> getEmployee(int empId) {
		return employeeRepository.findById(empId);
	}

}

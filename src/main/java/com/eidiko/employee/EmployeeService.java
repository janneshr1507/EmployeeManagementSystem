package com.eidiko.employee;

import java.util.List;
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
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	
	public boolean deleteEmployee(int empId) {
		
		boolean isThere = employeeRepository.existsById(empId);
		if(isThere) {
			employeeRepository.deleteById(empId);
			return true;
		} 
		return false;
	}
	
	public boolean updateEmployee(Employee employee) {
		
		boolean isThere = employeeRepository.existsById(employee.getEmpId());
		if(isThere) {
			employeeRepository.save(employee);
			return true;
		}
		
		return false;
	}
}

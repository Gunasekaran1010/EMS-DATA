package net.javaguide.emsbackend.service;

import java.util.List;

import net.javaguide.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee (EmployeeDto employeeDto );
	
	EmployeeDto getEmployeebyiD (Long employeeid);
	
	List<EmployeeDto> getallemployee();
	
	EmployeeDto updateEmployeeDto(Long employeeidLong , EmployeeDto updatEmployeeDto);
	
	void deleteEmployedeatil(Long employeeids);
}

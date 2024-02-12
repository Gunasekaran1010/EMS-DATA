package net.javaguide.emsbackend.mapper;

import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.entity.Employee;

public class EmployeeMapper {

	
	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		 return new EmployeeDto(
				 employee.getId(),
				 employee.getFirstName(),
				 employee.getLastName(),
				 employee.getEmail()
				 
	       );
		
	}
	
	public static Employee maptoEmployee (EmployeeDto employeeDto ) {
		
		return new Employee (
				
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				
				);
	}
}

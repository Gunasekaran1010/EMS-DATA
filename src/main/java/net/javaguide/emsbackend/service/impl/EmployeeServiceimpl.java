package net.javaguide.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.entity.Employee;
import net.javaguide.emsbackend.exception.ResourceNotFoundException;
import net.javaguide.emsbackend.mapper.EmployeeMapper;
import net.javaguide.emsbackend.respository.EmployeeRepository;
import net.javaguide.emsbackend.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
	
	 private EmployeeRepository employeeRepository ;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee  = EmployeeMapper.maptoEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.maptoEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeebyiD(Long employeeid) {
		
	 Employee employee = 	employeeRepository.findById(employeeid)
					.orElseThrow(  () -> new ResourceNotFoundException("Employee by id not found in db" + employeeid) );
		
		return EmployeeMapper.maptoEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getallemployee() {
		
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployeeDto(Long employeeidLong, EmployeeDto updatEmployeeDto) {
	 Employee employee = 	employeeRepository.findById(employeeidLong).orElseThrow(
				() -> new ResourceNotFoundException("Employee id not found " + employeeidLong)
				);
	 
	 employee.setFirstName(updatEmployeeDto.getFirstName());
	 employee.setLastName(updatEmployeeDto.getLastName());
	 employee.setEmail(updatEmployeeDto.getEmail());
	 
	 Employee updaEmployeedetailEmployee =  employeeRepository.save(employee);
		return EmployeeMapper.maptoEmployeeDto(updaEmployeedetailEmployee);
	}

	
	@Override
	public void deleteEmployedeatil(Long employeeids) {
		
		Employee employee = 	employeeRepository.findById(employeeids)
				.orElseThrow(  () -> new ResourceNotFoundException("Employee by id not found in db" + employeeids) );
	
		employeeRepository.deleteById(employeeids);
	}

}

package net.javaguide.emsbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.service.EmployeeService;

@CrossOrigin("*") 
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService; 
	
	
	// build api working function 
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createemploydataEntity( @RequestBody EmployeeDto employeeDto) {
		
	  EmployeeDto svaedeEmployeeDto =	employeeService.createEmployee(employeeDto);
	  return new ResponseEntity<>(svaedeEmployeeDto , HttpStatus.CREATED);
		
	}
	
	// get by id

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeebyid(@PathVariable("id") Long empmployeeid){
		 EmployeeDto employeeDto = 	employeeService.getEmployeebyiD(empmployeeid);
		 return ResponseEntity.ok(employeeDto);
	}
	
	// get all emp details
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getallempdetails(){
		List<EmployeeDto>  employeeDtos= employeeService.getallemployee();
		return ResponseEntity.ok(employeeDtos);
	}
	
	// get 
	
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateemployeedetail( @PathVariable("id") Long employeeidLong ,
															 @RequestBody 	EmployeeDto updatEmployeeDto){
		
	 EmployeeDto employeeDto = 	employeeService.updateEmployeeDto(employeeidLong, updatEmployeeDto);
	 
	 return ResponseEntity.ok(employeeDto);
	}
	
	// delete
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteidemployee(@PathVariable("id") Long employeeid){
		
		employeeService.deleteEmployedeatil(employeeid);
		
		return ResponseEntity.ok("Employee deletedd data");
		
	}
}

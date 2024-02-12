package net.javaguide.emsbackend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.emsbackend.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee ,Long> {

}

package com.springboot.app.repository;

import com.springboot.app.model.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package com.springboot.app.service.impl;

import com.springboot.app.model.Employee;
import com.springboot.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee AddEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

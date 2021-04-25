package com.service;

import com.exception.NotFoundException;
import com.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long employeeId) throws NotFoundException ;

    Employee createEmployee(Employee employee) ;

    Employee updateEmployee(Employee employee) throws NotFoundException;

    Boolean deleteEmployee(Long employeeId) throws NotFoundException;



}

package com.service;

import com.dao.EmployeeDao;
import com.exception.NotFoundException;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws NotFoundException {
        Employee employee = employeeDao.findById(employeeId).
                orElseThrow(() -> new NotFoundException("Employee not found for this id::" + employeeId));

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) throws NotFoundException {
        return employeeDao.save(employee);
    }

    @Override
    public Boolean deleteEmployee(Long employeeId) throws NotFoundException {
        Employee employee = employeeDao.findById(employeeId).
                orElseThrow(() -> new NotFoundException("Employee not found for this id::" + employeeId));
        employeeDao.delete(employee);

        return Boolean.TRUE;
    }
}

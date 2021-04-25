package com.service;

import com.exception.NotFoundException;
import com.model.Department;

import java.util.List;

public interface DepartmentService {

        List<Department> getAllDepartment();

        Department getDepartmentById(Long departmentId) throws NotFoundException;

        Department createDepartment(Department department);

        Department updateDepartment(Department department)throws NotFoundException ;

        Boolean deleteDepartment(Long departmentId)throws NotFoundException ;

        }

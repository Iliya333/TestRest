package com.service;

import com.dao.DepartmentDao;
import com.exception.NotFoundException;
import com.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService {


    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImp(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws NotFoundException {
        Department department = departmentDao.findById(departmentId).
                orElseThrow(() -> new NotFoundException("Department not found for this id " + departmentId));

        return department;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Department updateDepartment(Department department) throws NotFoundException {
        return departmentDao.save(department);
    }

    @Override
    public Boolean deleteDepartment(Long departmentId) throws NotFoundException {
        Department department= departmentDao.findById(departmentId).
                orElseThrow(() -> new NotFoundException("Department not found for this id::" + departmentId));
        departmentDao.delete(department);
        return Boolean.TRUE;
    }
}

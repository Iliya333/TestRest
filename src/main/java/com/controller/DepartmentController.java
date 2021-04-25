package com.controller;

import com.exception.NotFoundException;
import com.model.Department;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("departments")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }


    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long departmentId) throws NotFoundException {

        return ResponseEntity.ok().body( departmentService.getDepartmentById(departmentId));
    }

    @PostMapping("/departments")
    public Department createDepartment(Department department) {

        return departmentService.createDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Department department) throws NotFoundException {

        return ResponseEntity.ok( departmentService.updateDepartment(department));
    }

    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Long departmentId) throws NotFoundException {
        departmentService.deleteDepartment(departmentId);
        Map<String, Boolean> respons = new HashMap<>();
        respons.put("deleted", Boolean.TRUE);

        return respons;
    }


}

package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment Controller.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getdDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}

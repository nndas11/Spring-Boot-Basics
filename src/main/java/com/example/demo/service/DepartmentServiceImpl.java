package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRespository departmentRespository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRespository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRespository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Available.");
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRespository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDb = departmentRespository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && "".equalsIgnoreCase(department.getDepartmentName())){
            departmentDb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && "".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && "".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRespository.save(departmentDb);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRespository.findByDepartmentNameIgnoreCase((departmentName));
    }

}

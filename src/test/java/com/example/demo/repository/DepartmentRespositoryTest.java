package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRespositoryTest {

    @Autowired
    private DepartmentRespository departmentRespository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentCode("IT-01")
                .departmentAddress("Kochi")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenfindById_thenReturnDepartment(){
        Department found = departmentRespository.findById(1L).get();
        assertEquals(found.getDepartmentName(),"IT");
    }
}
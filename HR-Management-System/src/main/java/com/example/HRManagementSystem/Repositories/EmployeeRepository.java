package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.DepartmentEntity;
import com.example.HRManagementSystem.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByDepartment(DepartmentEntity department);
}
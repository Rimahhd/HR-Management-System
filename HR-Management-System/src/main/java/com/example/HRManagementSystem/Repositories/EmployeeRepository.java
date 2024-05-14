package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.DepartmentEntity.DepartmentEntity;
import com.example.HRManagementSystem.Entities.EmployeeEntity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByDepartmentId(Integer departmentId);
}
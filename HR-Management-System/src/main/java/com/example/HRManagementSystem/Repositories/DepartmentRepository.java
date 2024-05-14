package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.DepartmentEntity.DepartmentEntity;
import com.example.HRManagementSystem.Entities.EmployeeEntity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}

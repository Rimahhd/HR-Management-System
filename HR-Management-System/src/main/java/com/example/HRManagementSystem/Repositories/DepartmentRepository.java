package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
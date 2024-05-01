package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.Department;
import com.example.HRManagementSystem.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Department department);
}
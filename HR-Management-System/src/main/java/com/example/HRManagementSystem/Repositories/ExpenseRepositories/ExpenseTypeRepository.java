package com.example.HRManagementSystem.Repositories.ExpenseRepositories;

import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeEntity, Long> {
}
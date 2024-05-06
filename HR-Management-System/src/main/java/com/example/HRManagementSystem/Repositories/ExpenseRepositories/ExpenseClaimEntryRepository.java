package com.example.HRManagementSystem.Repositories.ExpenseRepositories;

import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseTypeEntity, Long> {
    List<ExpenseTypeEntity> findByExpenseClaimEntity(ExpenseClaimEntity expenseClaimEntity);
}
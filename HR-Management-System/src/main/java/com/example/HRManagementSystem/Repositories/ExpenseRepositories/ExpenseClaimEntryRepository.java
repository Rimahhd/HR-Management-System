package com.example.HRManagementSystem.Repositories.ExpenseRepositories;

import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseEntryEntity, Long> {
    //List<ExpenseEntryEntity> findByExpenseClaimEntity(ExpenseClaimEntity expenseClaimEntity);
}

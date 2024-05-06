package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.ExpenseClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseclaimRepository extends JpaRepository<ExpenseClaimEntity, Integer> {
}
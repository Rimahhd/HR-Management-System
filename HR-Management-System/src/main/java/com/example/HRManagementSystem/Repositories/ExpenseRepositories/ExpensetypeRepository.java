package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.ExpenseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensetypeRepository extends JpaRepository<ExpenseTypeEntity, Integer> {
}
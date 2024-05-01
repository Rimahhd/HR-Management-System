package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.Expenseclaimentry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseclaimentryRepository extends JpaRepository<Expenseclaimentry, Integer> {
}
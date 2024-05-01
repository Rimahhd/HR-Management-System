package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.Expenseclaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseclaimRepository extends JpaRepository<Expenseclaim, Integer> {
}
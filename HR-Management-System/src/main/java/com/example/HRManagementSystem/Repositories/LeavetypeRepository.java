package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.LeaveTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavetypeRepository extends JpaRepository<LeaveTypeEntity, Integer> {
}
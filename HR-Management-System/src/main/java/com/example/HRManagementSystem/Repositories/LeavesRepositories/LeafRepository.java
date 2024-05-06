package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeafRepository extends JpaRepository<LeaveEntity, Integer> {
}
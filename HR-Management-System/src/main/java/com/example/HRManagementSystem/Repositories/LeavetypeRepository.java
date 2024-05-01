package com.example.HRManagementSystem.Repositories;

import com.example.HRManagementSystem.Entities.Leavetype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeavetypeRepository extends JpaRepository<Leavetype, Integer> {
}
package com.example.HRManagementSystem.Repositories.LeavesRepositories;

import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveTypeEntity, Integer> {
}
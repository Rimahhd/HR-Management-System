package com.example.HRManagementSystem.Repositories.LeavesRepositories;

import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveEntity;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


public interface LeaveRepository extends JpaRepository<LeaveEntity, Integer> {
    List<LeaveEntity> findByEmployeeIdAndFromDateBetween(Integer employeeId, LocalDate fromDate, LocalDate toDate);

    Page<LeaveEntity> findByLeaveTypeAndEmployeeId(LeaveTypeEntity leaveType, Integer employeeId, Pageable pageable);

}
package com.example.HRManagementSystem.Services.ExpenseServices;

import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import com.example.HRManagementSystem.Repositories.ExpenseRepositories.ExpenseClaimRepository;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

public interface ExpenseClaimService {
    void submitExpense(ExpenseClaimDTO expenseClaimDTO);

    Map<String, Map<String, Double>> getTotalClaimsPerTypePerEmployee();

    ExpenseClaimRepository expenseClaimRepository = null;
    Long employeeId = null;

    ExpenseClaimDTO create(ExpenseClaimDTO expenseClaimDTO);


    ExpenseClaimDTO update(ExpenseClaimDTO expenseClaimDTO);

    ExpenseClaimDTO get(int id);

    ExpenseClaimDTO delete(int id);

    ResponseEntity<ExpenseClaimEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<ExpenseClaimDTO> getEntity(int id, Map<String, Object> expenseClaimDTO);

    ResponseEntity<ExpenseClaimDTO> getAllEntity(int id, Map<String, Object> expenseClaimDTO);

    ResponseEntity<ExpenseClaimEntity> updateEntity(int id, Map<String, Object> expenseClaimDTO);

//    List<ExpenseClaimEntityEntity> expenseClaims = expenseClaimRepository.findByEmployeeId(employeeId);

    void saveExpenseClaimEntity(ExpenseClaimEntity expenseClaim);

    List<ExpenseClaimEntity> getAllExpenseClaims();
}


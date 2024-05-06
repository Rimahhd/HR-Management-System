package com.example.HRManagementSystem.Services.ExpenseServices;

import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseTypeEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;


public interface ExpenseClaimEntryService {

    ExpenseClaimEntryDTO create(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO update(ExpenseClaimEntryDTO expenseClaimEntryDTO);

    ExpenseClaimEntryDTO get(int id);

    ExpenseClaimEntryDTO delete(int id);

    List<ExpenseClaimEntryDTO> getExpenseClaimEntriesByClaimId(Integer expenseClaimId);

    ResponseEntity<ExpenseTypeEntity> deleteEntity(int id) throws IllegalAccessException;

    ResponseEntity<ExpenseClaimEntryDTO> getEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseClaimEntryDTO> getAllEntity(int id, Map<String, Object> expenseClaimEntryDTO);

    ResponseEntity<ExpenseTypeEntity> updateEntity(int id, Map<String, Object> expenseClaimEntryDTO);
}

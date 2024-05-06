package com.example.HRManagementSystem.Services.ExpenseServices;

import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseTypeDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseTypeEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ExpenseTypeService {

    ExpenseTypeDTO create(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO update(ExpenseTypeDTO expenseTypeDTO);

    ExpenseTypeDTO get(int id);

    ExpenseTypeDTO delete(int id);

    ResponseEntity<ExpenseTypeEntity> deleteEntity(int id) throws IllegalAccessException;


    ExpenseTypeEntity createExpenseType(ExpenseTypeEntity expenseType);

    String getExpenseTypeNameById(Long expenseTypeId);

    List<ExpenseTypeEntity> getAllExpenseTypes();
}

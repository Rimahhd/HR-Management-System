package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseClaimEntryDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseClaimEntryMapper {
    ExpenseClaimEntryDTO expenseClaimEntryToDto(ExpenseEntryEntity expenseClaimEntry);
    ExpenseEntryEntity dtoToExpenseClaimEntry(ExpenseClaimEntryDTO dto);
}

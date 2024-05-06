package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseClaimEntryDTO;
import com.example.HRManagementSystem.Entities.Expenseclaimentry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseClaimEntryMapper {
    ExpenseClaimEntryDTO expenseClaimEntryToDto(Expenseclaimentry expenseClaimEntry);
    Expenseclaimentry dtoToExpenseClaimEntry(ExpenseClaimEntryDTO dto);
}

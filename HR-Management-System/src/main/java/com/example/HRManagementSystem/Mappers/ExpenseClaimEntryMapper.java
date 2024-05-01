package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseclaimentryDto;
import com.example.HRManagementSystem.Entities.Expenseclaimentry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseClaimEntryMapper {
    ExpenseclaimentryDto expenseClaimEntryToDto(Expenseclaimentry expenseClaimEntry);
    Expenseclaimentry dtoToExpenseClaimEntry(ExpenseclaimentryDto dto);
}

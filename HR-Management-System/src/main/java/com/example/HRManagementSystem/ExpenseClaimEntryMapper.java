package com.example.HRManagementSystem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseClaimEntryMapper {
    ExpenseclaimentryDto expenseClaimEntryToDto(Expenseclaimentry expenseClaimEntry);
    Expenseclaimentry dtoToExpenseClaimEntry(ExpenseclaimentryDto dto);
}

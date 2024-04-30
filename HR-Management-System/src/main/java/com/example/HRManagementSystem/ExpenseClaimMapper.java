package com.example.HRManagementSystem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseClaimMapper {
    ExpenseclaimDto expenseClaimToDto(Expenseclaim expenseClaim);
    Expenseclaim dtoToExpenseClaim(ExpenseclaimDto dto);
}

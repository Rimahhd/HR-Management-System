package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseclaimDto;
import com.example.HRManagementSystem.Entities.Expenseclaim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExpenseClaimMapper {
    ExpenseclaimDto expenseClaimToDto(Expenseclaim expenseClaim);
    Expenseclaim dtoToExpenseClaim(ExpenseclaimDto dto);
}

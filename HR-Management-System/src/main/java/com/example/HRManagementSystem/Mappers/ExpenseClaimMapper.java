package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseClaimDTO;
import com.example.HRManagementSystem.Entities.Expenseclaim;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseClaimMapper {
    ExpenseClaimDTO expenseClaimToDto(Expenseclaim expenseClaim);
    Expenseclaim dtoToExpenseClaim(ExpenseClaimDTO dto);
}

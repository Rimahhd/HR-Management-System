package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseClaimDTO;
import com.example.HRManagementSystem.Entities.ExpenseClaimEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseClaimMapper {
    ExpenseClaimDTO expenseClaimToDto(ExpenseClaimEntity expenseClaim);
    ExpenseClaimEntity dtoToExpenseClaim(ExpenseClaimDTO dto);
}

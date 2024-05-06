package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseClaimMapper {
    ExpenseClaimMapper INSTANCE = Mappers.getMapper(ExpenseClaimMapper.class);

    ExpenseClaimDTO ExpenseClaimEntityToExpenseClaimDTO(ExpenseClaimEntity expenseClaimEntity);

    ExpenseClaimEntity ExpenseClaimDTOToExpenseClaimEntity(ExpenseClaimDTO expenseClaimDTO);
}

package com.example.HRManagementSystem;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link Expenseclaimentry}
 */
@Value
public class ExpenseclaimentryDto implements Serializable {
    Integer id;
    LocalDate date;
    Integer expenseTypeId;
    String expenseTypeName;
    Integer expenseClaimId;
    LocalDate expenseClaimDate;
    String expenseClaimDescription;
    BigDecimal expenseClaimTotal;
    String expenseClaimStatus;
    Integer expenseClaimEmployeeId;
    String expenseClaimEmployeeName;
    String expenseClaimEmployeeEmail;
    String expenseClaimEmployeeAddress;
    Department expenseClaimEmployeeDepartment;
    String description;
    BigDecimal total;
}
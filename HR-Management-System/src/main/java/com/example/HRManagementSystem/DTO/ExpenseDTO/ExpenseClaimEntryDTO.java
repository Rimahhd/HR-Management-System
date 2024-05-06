package com.example.HRManagementSystem.DTO.ExpenseDTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpenseClaimEntryDTO {

    private Integer entryId;
    private LocalDate entryDate;
    private String entryType;
    private String entryDescription;
    private Integer ExpenseClaimId;
    private Integer ExpenseTypeId;
    private String expenseType;
    private Double total;

}


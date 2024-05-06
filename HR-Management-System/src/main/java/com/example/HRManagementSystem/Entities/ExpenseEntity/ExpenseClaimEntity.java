package com.example.HRManagementSystem.Entities.ExpenseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "expense_claim_entity", schema = "hr-management-system", catalog = "")
public class ExpenseClaimEntity {


    @Id
    @Basic
    @Column(name = "expense_claim_id")
    private int expenseClaimId;
    @Basic
    @Column(name = "expense_claim_total")
    private Integer expenseClaimTotal;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic
    @Column(name = "expense_claim_date")
    private Date expenseClaimDate;
    @Basic
    @Column(name = "expense_claim_status")
    private String expenseClaimStatus;

    public int getExpenseClaimId() {
        return expenseClaimId;
    }

    public void setExpenseClaimId(int expenseClaimId) {
        this.expenseClaimId = expenseClaimId;
    }
}

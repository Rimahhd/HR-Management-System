package com.example.HRManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "expenseclaimentry")
public class Expenseclaimentry {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_type_id")
    private Expensetype expenseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_claim_id")
    private Expenseclaim expenseClaim;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

}
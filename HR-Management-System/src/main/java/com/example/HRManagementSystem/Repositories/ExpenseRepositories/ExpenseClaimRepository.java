package com.example.HRManagementSystem.Repositories.ExpenseRepositories;

import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.List;


public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaimEntity, Long> {
}
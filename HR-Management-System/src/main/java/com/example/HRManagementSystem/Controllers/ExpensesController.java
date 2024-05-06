package com.example.HRManagementSystem.Controllers;

import com.example.HRManagementSystem.ApiResponse;
import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseClaimDTO;
import com.example.HRManagementSystem.DTO.ExpenseDTO.ExpenseClaimEntryDTO;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseClaimEntity;
import com.example.HRManagementSystem.Entities.ExpenseEntity.ExpenseTypeEntity;
import com.example.HRManagementSystem.Repositories.DepartmentRepository;
import com.example.HRManagementSystem.Repositories.ExpenseRepositories.ExpenseClaimEntryRepository;
import com.example.HRManagementSystem.Repositories.ExpenseRepositories.ExpenseClaimRepository;
import com.example.HRManagementSystem.Repositories.ExpenseRepositories.ExpenseTypeRepository;
import com.example.HRManagementSystem.Services.EmployeeServices.EmployeeService;
import com.example.HRManagementSystem.Services.ExpenseServices.ExpenseClaimEntryService;
import com.example.HRManagementSystem.Services.ExpenseServices.ExpenseClaimService;
import com.example.HRManagementSystem.Services.ExpenseServices.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("HRManagementSystem/api/v1/expenses")
public class ExpensesController {
    private final ExpenseClaimService expenseClaimService;
    private final ExpenseTypeService expenseTypeService;
    private ExpenseClaimEntryService expenseClaimEntryService;

    public ApiResponse response;

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private ExpenseClaimEntryRepository expenseClaimEntryRepository;

    @Autowired
    private ExpenseClaimRepository expenseClaimRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public ExpensesController(
            ExpenseClaimService expenseClaimService,
            ExpenseTypeService expenseTypeService
    ) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
    }

    public ExpensesController(
            ExpenseClaimService expenseClaimService,
            ExpenseTypeService expenseTypeService,
            ExpenseClaimEntryService expenseClaimEntryService
    ) {
        this.expenseClaimService = expenseClaimService;
        this.expenseTypeService = expenseTypeService;
        this.expenseClaimEntryService = expenseClaimEntryService;
    }

    // Define expense claim types
    @PostMapping("/expense-types")
    public ExpenseTypeEntity createExpenseType(@RequestBody ExpenseTypeEntity expenseTypeEntity) {
        return expenseTypeRepository.save(expenseTypeEntity);
    }

    // Submit the expense
    @PostMapping("/submit-expense")
    public ApiResponse submitExpense(@RequestBody ExpenseClaimDTO expenseClaimDTO) {
        ExpenseClaimEntity expenseClaimEntity = new ExpenseClaimEntity();
        expenseClaimEntity.setExpenseClaimDate((java.sql.Date) new Date(System.currentTimeMillis()));
//        expenseClaimEntity.setDescription(expenseClaimEntryDTO.getDescription());
//        expenseClaimEntity.setExpenseClaimTotal(expenseClaimDTO.getTotal()); // Total amount

        // Save the expense claim entity
        expenseClaimService.saveExpenseClaimEntity(expenseClaimEntity);
        response.setMessage("Expense claim submitted successfully");
        return response;
    }

    // Get total claims of each type per employee
    @GetMapping("/total-claims")
    public ResponseEntity<Map<String, Map<String, BigDecimal>>> getTotalClaimsPerTypePerEmployee() {
        List<ExpenseClaimEntity> expenseClaims = expenseClaimService.getAllExpenseClaims();
        List<ExpenseTypeEntity> expenseTypes = expenseTypeService.getAllExpenseTypes();

        Map<String, Map<String, BigDecimal>> totalClaimsData = new HashMap<>();

        for (ExpenseClaimEntity expenseClaim : expenseClaims) {
            String employeeId = expenseClaim.getEmployeeId().toString();
            Map<String, BigDecimal> claimsPerType = totalClaimsData.computeIfAbsent(employeeId, k -> new HashMap<>());

            List<ExpenseClaimEntryDTO> entries = expenseClaimEntryService.getExpenseClaimEntriesByClaimId(expenseClaim.getExpenseClaimId());
            for (ExpenseClaimEntryDTO entry : entries) {
                String expenseTypeId = String.valueOf(entry.getExpenseTypeId());
                String expenseTypeName = getExpenseTypeNameById(expenseTypes, expenseTypeId);
//                BigDecimal totalAmount = entry.getExpenseClaimEntryTotal();

//                claimsPerType.put(expenseTypeName, claimsPerType.getOrDefault(expenseTypeName, BigDecimal.ZERO).add(totalAmount));
            }
        }
        return ResponseEntity.ok(totalClaimsData);
    }

    // Utility method to get the expense type name based on the expenseTypeId
    private String getExpenseTypeNameById(List<ExpenseTypeEntity> expenseTypes, String expenseTypeId) {
        for (ExpenseTypeEntity expenseType : expenseTypes) {
            if (String.valueOf(expenseType.getExpenseTypeId()).equals(expenseTypeId)) {
                return expenseType.getExpenseTypeName();
            }
        }
        return "";
    }
}


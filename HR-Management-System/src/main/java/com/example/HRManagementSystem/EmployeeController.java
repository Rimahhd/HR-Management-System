package com.example.HRManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/departments")
    public ResponseEntity<ApiResponse<DepartmentDto>> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto createdDepartment = employeeService.createDepartment(departmentDto);
        ApiResponse<DepartmentDto> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Department created successfully");
        response.setReturnField(createdDepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<EmployeeDto>> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        ApiResponse<EmployeeDto> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Employee created successfully");
        response.setReturnField(createdEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDto>> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        ApiResponse<EmployeeDto> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Employee updated successfully");
        response.setReturnField(updatedEmployee);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<ApiResponse<List<EmployeeDto>>> getEmployeesByDepartment(@PathVariable("departmentId") Long departmentId) {
        List<EmployeeDto> employees = employeeService.getEmployeesByDepartment(departmentId);
        ApiResponse<List<EmployeeDto>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Employees retrieved successfully");
        response.setReturnField(employees);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}


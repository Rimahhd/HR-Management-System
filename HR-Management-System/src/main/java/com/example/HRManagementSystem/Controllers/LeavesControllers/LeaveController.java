package com.example.HRManagementSystem.Controllers.LeavesControllers;

import com.example.HRManagementSystem.ApiResponse;
import com.example.HRManagementSystem.DTO.EmployeeDTO.EmployeeDTO;
import com.example.HRManagementSystem.Entities.EmployeeEntity.EmployeeEntity;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveEntity;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveTypeEntity;
import com.example.HRManagementSystem.Repositories.EmployeeRepository;
import com.example.HRManagementSystem.Repositories.LeavesRepositories.LeaveTypeRepository;
import com.example.HRManagementSystem.Services.EmployeeServices.EmployeeService;
import com.example.HRManagementSystem.Services.LeavesServices.LeaveService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@Data
@RestController
@RequestMapping("/HRManagementSystem/api/v1/leaves")

public class LeaveController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final LeaveService leaveService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    private ApiResponse response;

    public LeaveController(LeaveService leaveService, EmployeeService employeeService) {
        this.leaveService = leaveService;
        this.employeeService = employeeService;
        this.response = new ApiResponse();
    }

    @GetMapping("/get/leave/all")
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/get/leave/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {

        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/create/leave/{id}")
    public ApiResponse createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeDTO.getName());
        response.setMessage("Employee information CREATED successfully");
        return (response);
    }

    @PatchMapping("/update/leave/{id}")
    public ApiResponse updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> employeeDetails) {
        employeeService.updateEntity(id, employeeDetails);
        ApiResponse response = new ApiResponse();
        response.setMessage("Employee information UPDATED successfully");
        return (response);
    }


    @DeleteMapping("/delete/leave/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws IllegalAccessException {
        employeeService.deleteEntity(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Employee information DELETED successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }


    //Submit a leave request for an employee
    @PostMapping("/submit/leaves")
    public LeaveEntity submitLeaveRequest(
            @RequestParam("employeeId") Integer employeeId,
            @RequestParam("leaveTypeId") Integer leaveTypeId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate,
            @RequestParam("note") String note) {
        return leaveService.submitLeaveRequest(employeeId, leaveTypeId, fromDate, toDate, note);
    }

    //Retrieve leaves for a specific employee within a date range
    @GetMapping("/employees/{employeeId}/leaves")
    public List<LeaveEntity> getLeavesByEmployeeAndDateRange(
            @PathVariable Integer employeeId,
            @RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return leaveService.getLeavesByEmployeeAndDateRange(employeeId, fromDate, toDate);
    }

    @GetMapping("/leaves")
    public Page<LeaveEntity> getLeavesByTypeAndEmployee(
            @RequestParam("leaveTypeId") Integer leaveTypeId,
            @RequestParam("employeeId") Integer employeeId,
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        LeaveTypeEntity leaveType = leaveTypeRepository.getById(leaveTypeId);
        return leaveService.getLeavesByTypeAndEmployee(leaveType, employeeId, page, size);
    }
}



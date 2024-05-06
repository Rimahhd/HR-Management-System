package com.example.HRManagementSystem.Controllers;

import com.example.HRManagementSystem.ApiResponse;
import com.example.HRManagementSystem.DTO.DepartmentDTO.DepartmentDTO;
import com.example.HRManagementSystem.Entities.DepartmentEntity.DepartmentEntity;
import com.example.HRManagementSystem.Repositories.DepartmentRepository;
import com.example.HRManagementSystem.Services.DepartmentServices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final DepartmentService departmentService;
    private ApiResponse response;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments/create")
    public ApiResponse createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentEntity department = new DepartmentEntity();
        department.setDepartmentName(departmentDTO.getName());
        response.setMessage("Department information CREATED successfully");
        return (response);
    }

    @GetMapping("/departments/all")
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/departments/{id}")
    public DepartmentDTO getDepartment(@PathVariable int id) {
        System.out.println("getDepartment");
        System.out.println(departmentService.findDepartmentById(id));
        return departmentService.findDepartmentById((int) id);
    }

    @PatchMapping("/departments/{id}")
    public ApiResponse updateDepartment(@PathVariable int id, @RequestBody Map<String, Object> departmentDetails) {
        departmentService.updateEntity(id, departmentDetails);
        ApiResponse response = new ApiResponse();
        response.setMessage("Department information UPDATED successfully");
        return (response);
    }


    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) throws IllegalAccessException {
        departmentService.deleteEntity(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Department information DELETED successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }
}


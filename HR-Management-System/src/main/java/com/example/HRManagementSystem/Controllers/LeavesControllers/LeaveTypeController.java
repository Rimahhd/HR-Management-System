package com.example.HRManagementSystem.Controllers.LeavesControllers;

import com.example.HRManagementSystem.ApiResponse;
import com.example.HRManagementSystem.DTO.LeavesDTO.LeaveTypeDTO;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveTypeEntity;
import com.example.HRManagementSystem.Repositories.LeavesRepositories.LeaveTypeRepository;
import com.example.HRManagementSystem.Services.LeavesServices.LeaveTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@Data
@RestController
@RequestMapping("/HRManagementSystem/api/v1/leavetypes")

public class LeaveTypeController {

    @Autowired
    private final LeaveTypeRepository leaveTypeRepository;

    private LeaveTypeService leaveTypeService;

    private ApiResponse response;

    public LeaveTypeController(LeaveTypeRepository leaveTypeRepository) {

        this.leaveTypeService = leaveTypeService;
        this.leaveTypeRepository = leaveTypeRepository;
    }

    @GetMapping("/leaveType/all")
    public List<LeaveTypeEntity> getLeaveType() {
        return leaveTypeRepository.findAll();
    }

    @GetMapping("/leaveType/{id}")
    public LeaveTypeDTO getLeaveType(@PathVariable int id) {

        return leaveTypeService.findLeaveTypeById(id);
    }

    @PostMapping
    public ApiResponse createLeaveType(@RequestBody LeaveTypeDTO leaveTypeDTO) {
        LeaveTypeEntity leaveType = new LeaveTypeEntity();
        leaveType.setName(leaveTypeDTO.getName());
        ApiResponse response = new ApiResponse();
        response.setMessage("Leave Type CREATED successfully");
        return response;
    }


    @PatchMapping("/leaveType/{id}")
    public ApiResponse updateLeaveType(@PathVariable int id, @RequestBody Map<String, Object> leaveTypeDetails) {
        leaveTypeService.updateEntity(id, leaveTypeDetails);
        ApiResponse response = new ApiResponse();
        response.setMessage("Leave Type UPDATED successfully");
        return response;
    }


    @DeleteMapping("/delete/leaveType/{id}")
    public ResponseEntity<String> deleteLeaveType(@PathVariable int id) throws IllegalAccessException {
        leaveTypeService.deleteEntity(id);
        ApiResponse response = new ApiResponse();
        response.setMessage("Leave Type DELETED successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
    }

}



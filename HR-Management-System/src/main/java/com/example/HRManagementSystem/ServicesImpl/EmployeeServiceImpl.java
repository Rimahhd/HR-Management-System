package com.example.HRManagementSystem.ServicesImpl;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.DTO.EmployeeDto;
import com.example.HRManagementSystem.Entities.DepartmentEntity;
import com.example.HRManagementSystem.Entities.EmployeeEntity;
import com.example.HRManagementSystem.Mappers.EmployeeMapper;
import com.example.HRManagementSystem.Repositories.DepartmentRepository;
import com.example.HRManagementSystem.Repositories.EmployeeRepository;
import com.example.HRManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity department = departmentRepository.save(employeeMapper.dtoToDepartment(departmentDto));
        return employeeMapper.departmentToDto(department);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employee = employeeRepository.save(employeeMapper.dtoToEmployee(employeeDto));
        return employeeMapper.employeeToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Employee not found with id " + id));

        // Update existingEmployee fields with employeeDto data
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setAddress(employeeDto.getAddress());
        // Update other fields as required

        EmployeeEntity updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.employeeToDto(updatedEmployee);
    }


    @Override
    public List<EmployeeDto> getEmployeesByDepartment(Long departmentId) {
        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + departmentId));
        List<EmployeeEntity> employees = employeeRepository.findByDepartment(department);
        return employeeMapper.employeeListToDtoList(employees);
    }
}

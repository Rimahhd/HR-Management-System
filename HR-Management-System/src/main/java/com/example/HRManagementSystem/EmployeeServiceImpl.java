package com.example.HRManagementSystem;

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
        Department department = departmentRepository.save(employeeMapper.dtoToDepartment(departmentDto));
        return employeeMapper.departmentToDto(department);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.dtoToEmployee(employeeDto));
        return employeeMapper.employeeToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Employee not found with id " + id));

        // Update existingEmployee fields with employeeDto data
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setAddress(employeeDto.getAddress());
        // Update other fields as required

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.employeeToDto(updatedEmployee);
    }


    @Override
    public List<EmployeeDto> getEmployeesByDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + departmentId));
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employeeMapper.employeeListToDtoList(employees);
    }
}

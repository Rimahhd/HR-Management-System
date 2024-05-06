package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.DTO.EmployeeDto;
import com.example.HRManagementSystem.Entities.DepartmentEntity;
import com.example.HRManagementSystem.Entities.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto employeeToDto(EmployeeEntity employee);

    EmployeeEntity dtoToEmployee(EmployeeDto dto);

    DepartmentDto departmentToDto(DepartmentEntity department);

    DepartmentEntity dtoToDepartment(DepartmentDto dto);

    List<EmployeeDto> employeeListToDtoList(List<EmployeeEntity> employees);
}

package com.example.HRManagementSystem.Services.DepartmentServices;

import com.example.HRManagementSystem.DTO.DepartmentDTO.DepartmentDTO;
import com.example.HRManagementSystem.Entities.DepartmentEntity.DepartmentEntity;
import com.example.HRManagementSystem.Mappers.DepartmentMapper;
import com.example.HRManagementSystem.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;


    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDTO findDepartmentById(Integer id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow();
        return DepartmentMapper.DepartmentEntityToDepartmentDTO(departmentEntity);
    }

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        return null;
    }

    @Override
    public DepartmentDTO create(DepartmentDTO departmentDTO) {
        // Implementation code here
        return null;
    }

    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        // Implementation code here
        return null;
    }

    @Override
    public DepartmentDTO get(int id) {
        // Implementation code here
        return null;
    }

    @Override
    public DepartmentDTO delete(int id) {
        // Implementation code here
        return null;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        // Implementation code here
        return null;
    }

    @Override
    public ResponseEntity<DepartmentEntity> deleteEntity(int id) throws IllegalAccessException {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentDTO> getEntity(int id, Map<String, Object> departmentDTO) {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentDTO> getAllEntity(int id, Map<String, Object> departmentDTO) {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentEntity> updateEntity(int id, Map<String, Object> departmentDTO) {
        return null;
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<DepartmentEntity> updateEntity(Integer id, Map<String, Object> departmentDTO) {
        DepartmentEntity entityToUpdate = departmentRepository.findById(id).orElseThrow();
        updateEntity(departmentDTO, entityToUpdate, DepartmentEntity.class);
        departmentRepository.saveAndFlush(entityToUpdate);
        return ResponseEntity.ok(entityToUpdate);
    }

    @Override
    public ResponseEntity<DepartmentEntity> deleteEntity(Integer id) {
        DepartmentEntity entityToDelete = departmentRepository.findById(id).orElseThrow();
        departmentRepository.delete(entityToDelete);
        return ResponseEntity.ok(entityToDelete);
    }

    @Override
    public ResponseEntity<DepartmentDTO> getEntity(Integer id, Map<String, Object> departmentDTO) {
        // Implementation code here
        return null;
    }

    @Override
    public ResponseEntity<DepartmentDTO> getAllEntity(Integer id, Map<String, Object> departmentDTO) {
        DepartmentEntity entityToGetAll = departmentRepository.findById(id).orElseThrow();
        getAllEntity(departmentDTO, entityToGetAll, DepartmentEntity.class);
        departmentRepository.saveAndFlush(entityToGetAll);
        DepartmentDTO departmentDto = DepartmentMapper.DepartmentEntityToDepartmentDTO(entityToGetAll);
        return ResponseEntity.ok(departmentDto);
    }

    @Override
    public ResponseEntity<DepartmentEntity> createEntity(Map<String, Object> departmentDTO) {
        DepartmentEntity entityToCreate = new DepartmentEntity();
        createEntity(departmentDTO, entityToCreate, DepartmentEntity.class);
        departmentRepository.saveAndFlush(entityToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityToCreate);
    }

    @Override
    public String getDepartment(Integer id) {
        // Implementation code here
        return null;
    }

    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
        entityDTO.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(entityToUpdateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToUpdate, v);
        });
    }

    @Override
    public ResponseEntity<DepartmentEntity> updateEntity(long id, Map<String, Object> departmentDTO) {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentEntity> deleteEntity(long id) throws IllegalAccessException {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentDTO> getEntity(long id, Map<String, Object> departmentDTO) {
        return null;
    }

    @Override
    public void getEntity(Map<String, Object> entityDTO, Object entityToGet, Class entityToGetClass) {

    }

    public void getAllEntity(Map<String, Object> entityDTO, Object entityToGetAll, Class entityToGetAllClass) {
        entityDTO.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(entityToGetAllClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToGetAll, v);
        });
    }

    @Override
    public ResponseEntity<DepartmentDTO> getAllEntity(long id, Map<String, Object> departmentDTO) {
        return null;
    }

    public void createEntity(Map<String, Object> entityDTO, Object entityToCreate, Class entityToCreateClass) {
        entityDTO.forEach((k, v) -> {
            Field field = ReflectionUtils.findRequiredField(entityToCreateClass, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, entityToCreate, v);
        });
    }
}
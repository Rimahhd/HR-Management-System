package com.example.HRManagementSystem.Entities.DepartmentEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "department", schema = "hr-management-system", catalog = "")
public class DepartmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private Integer departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
package com.example.service;

import java.util.List;

import com.example.entity.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartmentById(Long id);
}

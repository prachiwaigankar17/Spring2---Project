package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Department;
import com.example.service.DepartmentService;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    @GetMapping("/departments/new")
    public String createDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "create_department";
    }

    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/edit/{id}")
    public String editDepartmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "edit_department";
    }

    @PostMapping("/departments/{id}")
    public String updateDepartment(@PathVariable Long id, @ModelAttribute("department") Department department) {
        Department existingDepartment = departmentService.getDepartmentById(id);
        existingDepartment.setDepartmentCode(department.getDepartmentCode());
        existingDepartment.setDepartmentName(department.getDepartmentName());
        departmentService.updateDepartment(existingDepartment);
        return "redirect:/departments";
    }

    @GetMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
}

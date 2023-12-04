package com.example.controller;

import com.example.entity.Instructor;
import com.example.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    
    @GetMapping("/instructors")
    public String listInstructors(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "instructors";
    }

    @GetMapping("/instructors/new")
    public String createInstructorForm(Model model) {
     
        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);
        return "create_instructor";
    }

    @PostMapping("/instructors")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor) {
        System.out.println("Received instructor: " + instructor);
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }

    @GetMapping("/instructors/edit/{id}")
    public String editInstructorForm(@PathVariable Long id, Model model) {
        model.addAttribute("instructor", instructorService.getInstructorById(id));
        return "edit_instructor";
    }

    @PostMapping("/instructors/{id}")
    public String updateInstructor(@PathVariable Long id,
                                   @ModelAttribute("instructor") Instructor instructor,
                                   Model model) {
      
        Instructor existingInstructor = instructorService.getInstructorById(id);
        existingInstructor.setId(id);
        existingInstructor.setFirstName(instructor.getFirstName());
        existingInstructor.setLastName(instructor.getLastName());
        existingInstructor.setEmail(instructor.getEmail());

      
        instructorService.updateInstructor(existingInstructor);
        return "redirect:/instructors";
    }

   
    @GetMapping("/instructors/{id}")
    public String deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructorById(id);
        return "redirect:/instructors";
    }
}

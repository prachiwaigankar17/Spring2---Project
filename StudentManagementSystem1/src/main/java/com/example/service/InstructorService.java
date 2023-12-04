package com.example.service;

import com.example.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Long id);

    void saveInstructor(Instructor instructor);

    void updateInstructor(Instructor instructor);

    void deleteInstructorById(Long id);
}


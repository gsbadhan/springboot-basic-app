package com.springbootapp.service;

import com.springbootapp.Dto.StudentDto;

public interface StudentService {
    StudentDto create(StudentDto studentDto);
    StudentDto delete(Long id);
}

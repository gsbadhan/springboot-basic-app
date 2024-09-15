package com.springbootapp.service;

import com.springbootapp.Dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentDto create(StudentDto studentDto) {
        return new StudentDto();
    }

    @Override
    public StudentDto delete(Long id) {
        return new StudentDto();
    }
}

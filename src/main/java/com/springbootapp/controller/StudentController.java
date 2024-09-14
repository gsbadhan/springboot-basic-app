package com.springbootapp.controller;

import com.springbootapp.model.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/v1/students")
@Slf4j
public class StudentController {

    @PostMapping
    public StudentDto create(@RequestBody StudentDto studentDto) {
        log.info("new create request for student={}", studentDto);
        return new StudentDto();
    }

    @DeleteMapping
    public StudentDto delete(Long id) {
        log.info("delete request for student id={}", id);
        return new StudentDto();
    }
}

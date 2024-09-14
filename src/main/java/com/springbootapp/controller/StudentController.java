package com.springbootapp.controller;

import com.springbootapp.model.StudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Api(tags = "students")
@RestController
@RequestMapping(value = "/v1/students")
@Slf4j
public class StudentController {

    @ApiOperation(value = "create student information")
    @PostMapping
    public StudentDto create(@RequestBody StudentDto studentDto) {
        log.info("new create request for student={}", studentDto);
        return new StudentDto();
    }

    @ApiOperation(value = "delete student information using id")
    @DeleteMapping
    public StudentDto delete(Long id) {
        log.info("delete request for student id={}", id);
        return new StudentDto();
    }
}

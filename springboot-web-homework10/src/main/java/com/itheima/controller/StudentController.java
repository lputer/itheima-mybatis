package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result selectAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
        PageBean pageBean = studentService.selectAll(page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable Integer[] ids){
        studentService.deleteById(ids);
        return Result.success();
    }

    @PostMapping
    public Result insertStudent(@RequestBody Student student){
        studentService.insert(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }
}

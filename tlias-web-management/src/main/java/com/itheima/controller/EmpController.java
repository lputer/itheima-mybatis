package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    // 前端传入page 页码 默认值为1 ,pageSize 每页数量 默认值为5 两个参数
    @GetMapping
    public Result selectAllEmp(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        // 调用service层,传入page,pageSize参数
        // data:{total=5,rows={id:1,name:...}} 封装total和rows
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        // 数据统一封装返回
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result insertEmp(@RequestBody Emp emp) {
        empService.insert(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        log.info("传入的对象,{}",emp);
        empService.update(emp);
        return Result.success();
    }
}

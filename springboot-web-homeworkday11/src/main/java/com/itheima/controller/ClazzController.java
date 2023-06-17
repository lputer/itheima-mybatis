package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result selectAll(String name, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
        PageBean pageBean = clazzService.selectAll(name, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable List<Integer> ids) {
        clazzService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Clazz clazz) {

        clazzService.insert(clazz);
        return Result.success();
    }
}

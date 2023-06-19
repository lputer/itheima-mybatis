package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {
    @Resource(name = "DeptServiceImplC")
    private DeptService deptService;

    @GetMapping
    public Result selectAll() {
        log.info("查询全部部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) throws Exception {
        log.info("删除部门信息,id={}", id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("新增部门信息{}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据id查询部门,id={}", id);
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门信息,{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}

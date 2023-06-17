package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp) {
        Emp emp1 = empService.getByUsernameAndPassword(emp);
        if (emp1 != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", emp1.getId());
            claims.put("username", emp1.getUsername());
            claims.put("name", emp1.getName());

            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("登录信息错误");
    }
}

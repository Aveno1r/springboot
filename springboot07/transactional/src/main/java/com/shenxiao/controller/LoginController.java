package com.shenxiao.controller;

import com.shenxiao.pojo.Emp;
import com.shenxiao.pojo.Result;
import com.shenxiao.service.EmpService;
import com.shenxiao.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result LoginEmp(@RequestBody Emp emp){
        Emp selectEmp = empService.selectEmp(emp);
        if (selectEmp != null){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",selectEmp.getId());
            claims.put("username",selectEmp.getUsername());
            claims.put("name",selectEmp.getName());

            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("账号或密码错误");
    }
}

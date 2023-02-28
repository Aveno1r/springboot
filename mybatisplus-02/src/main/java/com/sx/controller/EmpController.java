package com.sx.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sx.bean.Emp;
import com.sx.bean.PageBean;
import com.sx.bean.Result;
import com.sx.service.EmpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    public Result page(int page, int pageSize, String name, Short gender,
                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                     @DateTimeFormat(pattern =    "yyyy-MM-dd") LocalDate end){
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(name),Emp::getName,name);
        queryWrapper.eq(gender != null,Emp::getGender,gender);
        queryWrapper.ge(begin != null,Emp::getEntrydate,begin).le(end !=null,Emp::getEntrydate,end);

        empService.page(pageInfo,queryWrapper);

        return Result.success(pageInfo);
    }
}

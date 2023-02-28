package com.sx.controller;

import com.sx.pojo.Dept;
import com.sx.service.impl.DeptServiceImpl;
import com.sx.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    @RequestMapping(value = "/depts/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable Integer id) throws Exception {
        deptService.delete(id);
        return Result.success();
    }

    @RequestMapping(value = "/depts/{id}",method = RequestMethod.GET)
    public Result findDeptById(@PathVariable Integer id){
        Dept dept = deptService.findDeptById(id);
        return Result.success(dept);
    }

    @RequestMapping("/depts")
    public Result list(){
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}

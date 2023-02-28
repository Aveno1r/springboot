package com.shenxiao.controller;

import com.shenxiao.pojo.Dept;
import com.shenxiao.pojo.Result;
import com.shenxiao.service.DeptService;
import com.shenxiao.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result getAll(){
        List<Dept> deptList = deptService.getAll();
        return Result.success(deptList);
    }

    @RequestMapping(value = "/depts/{id}",method = RequestMethod.DELETE)
    public Result deleteDept(@PathVariable Integer id){
        deptService.deleteDept(id);
        return Result.success();
    }
    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    @RequestMapping(value = "/depts/{id}",method = RequestMethod.GET)
    public Result selectDeptById(@PathVariable Integer id){
        Dept dept = deptService.selectDeptById(id);
        return Result.success(dept);
    }
    @RequestMapping(value = "/depts",method = RequestMethod.PUT)
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }
}

package com.shenxiao.controller;

import com.shenxiao.pojo.Emp;
import com.shenxiao.pojo.PageBean;
import com.shenxiao.pojo.Result;
import com.shenxiao.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
           //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
//    @RequestMapping(value = "/emps",method = RequestMethod.GET)
//    public Result list(String name, Short gender, LocalDate begin, LocalDate end){
//        List<Emp> empList = empService.list(name, gender, begin, end);
//        return Result.success(empList);
//    }
    @RequestMapping(value = "/emps",method = RequestMethod.POST)
    public Result addEmp(@RequestBody Emp emp){
        empService.addEmp(emp);
        return Result.success();
    }

    @RequestMapping(value = "/emps/{id}",method = RequestMethod.GET)
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    @RequestMapping(value = "/emps",method = RequestMethod.PUT)
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }

    @RequestMapping(value = "/emps/{ids}",method = RequestMethod.DELETE)
    public Result deleteEmps(@PathVariable List<Integer> ids){
        empService.deleteEmps(ids);
        return Result.success();
    }


}

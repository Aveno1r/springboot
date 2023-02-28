package com.sx.controller;

import com.sx.pojo.Emp;
import com.sx.pojo.Result;
import com.sx.service.EmpService;
import com.sx.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

   @RequestMapping("/listEmp")
    public Result list(){
       List<Emp> empList = empService.listEmp();

       return Result.success(empList);
   }
}

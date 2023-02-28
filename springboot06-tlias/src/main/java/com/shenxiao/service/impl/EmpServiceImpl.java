package com.shenxiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shenxiao.annotation.Log;
import com.shenxiao.mapper.EmpMapper;
import com.shenxiao.pojo.Emp;
import com.shenxiao.pojo.PageBean;
import com.shenxiao.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page,Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end){
        PageHelper.startPage(page,pageSize);
        Page<Emp> p = empMapper.list(name, gender, begin, end);
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

//    @Override
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end) {
//        List<Emp> list = empMapper.list(name, gender, begin, end);
//        return list;
//    }
    @Log
    @Override
    public void deleteEmps(List<Integer> ids) {
        empMapper.deleteEmps(ids);
    }
    @Log
    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }
    @Log
    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }
    @Log
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp selectEmp(Emp emp) {
        if (emp.getUsername()==null||emp.getPassword()==null){
            return null;
        }
        return empMapper.selectEmp(emp);
    }

}

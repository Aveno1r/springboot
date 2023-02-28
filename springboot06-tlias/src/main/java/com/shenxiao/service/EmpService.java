package com.shenxiao.service;

import com.shenxiao.pojo.Emp;
import com.shenxiao.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */

public interface EmpService {
//    PageBean page(Integer page, Integer pageSize);

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

//    public List<Emp> list(String name,Short gender,LocalDate begin,LocalDate end);
    public void deleteEmps(List<Integer> ids);
    public void addEmp(Emp emp);

    public Emp getById(Integer id);

    public void update(Emp emp);

    public Emp selectEmp(Emp emp);
}

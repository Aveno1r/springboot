package com.shenxiao.service;

import com.shenxiao.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */

public interface DeptService {
    public List<Dept> getAll();

    public void deleteDept(Integer id);

    public void addDept(Dept dept);

    public Dept selectDeptById(Integer id);

    public void updateDept(Dept dept);
}

package com.shenxiao.service.impl;

import com.shenxiao.mapper.DeptMapper;
import com.shenxiao.pojo.Dept;
import com.shenxiao.pojo.Result;
import com.shenxiao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> getAll() {
        return deptMapper.getAll();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}

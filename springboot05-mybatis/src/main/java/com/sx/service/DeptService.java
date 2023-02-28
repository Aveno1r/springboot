package com.sx.service;

import com.sx.pojo.Dept;

import java.util.List;

public interface DeptService{
    public void delete(Integer id) throws Exception;

    public Dept findDeptById(Integer id);

    public List<Dept> list();
}

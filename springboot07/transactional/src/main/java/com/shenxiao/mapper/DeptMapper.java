package com.shenxiao.mapper;

import com.shenxiao.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    public List<Dept> getAll();

    public void deleteDept(Integer id);

    public void addDept(Dept dept);

    public Dept selectDeptById(Integer id);

    public void updateDept(Dept dept);
}

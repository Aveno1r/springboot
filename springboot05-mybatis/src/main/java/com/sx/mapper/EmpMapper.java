package com.sx.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.*;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where dept_id = #{deptId}")
    public void deleteByDeptId(Integer deptId);
}

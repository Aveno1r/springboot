package com.sx.mapper;

import com.sx.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log(create_time,description) values(#{createTime},#{description})")
    public void insert(DeptLog deptLog);
}

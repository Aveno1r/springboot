package com.shenxiao.mapper;

import com.github.pagehelper.Page;
import com.shenxiao.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();

//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

//    @Select("select * from emp")
    public Page<Emp> list(String name, Short gender,
                          LocalDate begin,
                          LocalDate end);
    public void deleteEmps(List<Integer> ids);
    @Delete("delete from emp where dept_id = #{deptId}")
    public void deleteByDeptId(Integer deptId);
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
        " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void addEmp(Emp emp);
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);
    @Update("update emp set image=#{image},username=#{username},name=#{name},gender=#{gender},job=#{job},entrydate=#{entrydate},dept_id=#{deptId} where id = #{id}")
    public void update(Emp emp);

    @Select(value = "select * from emp where username=#{username} and password = #{password}")
    public Emp selectEmp(Emp emp);
}


package com.sx.mapper;

import com.sx.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);

    @Select("select * from dept where id = #{id}")
    public Dept findDeptById(Integer id);

    @Select("select * from dept")
    public List<Dept> list();
}

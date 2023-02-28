package com.sx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sx.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {
}

package com.sx.service.impl;

import com.sx.annotation.MyLog;
import com.sx.mapper.DeptLogMapper;
import com.sx.mapper.DeptMapper;
import com.sx.mapper.EmpMapper;
import com.sx.pojo.Dept;
import com.sx.pojo.DeptLog;
import com.sx.service.DeptLogService;
import com.sx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);

            if(true){
                throw new Exception("出现异常了~~~");
            }

            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行力解散部门的操作,此时解散的是" + id+ "号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public Dept findDeptById(Integer id) {
        Dept dept = deptMapper.findDeptById(id);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        return dept;
    }
    @MyLog
    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }
}

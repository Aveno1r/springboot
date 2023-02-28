package com.sx.service.impl;

import com.sx.mapper.DeptLogMapper;
import com.sx.pojo.DeptLog;
import com.sx.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeptlogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {

        deptLogMapper.insert(deptLog);
    }

}

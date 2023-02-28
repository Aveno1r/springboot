package com.sx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sx.bean.Emp;
import com.sx.dao.EmpDao;
import com.sx.service.EmpService;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpDao, Emp> implements EmpService {
}

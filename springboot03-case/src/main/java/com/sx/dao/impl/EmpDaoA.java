package com.sx.dao.impl;

import com.sx.dao.EmpDao;
import com.sx.pojo.Emp;
import com.sx.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = EmpDaoA.class.getClassLoader().getResource("emp.xml").getFile();
        List<Emp> list = XmlParserUtils.parse(file, Emp.class);
        return list;
    }
}

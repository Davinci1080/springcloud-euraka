package com.itcast.service.impl;

import com.atcast.entity.Dept;
import com.itcast.mapper.DeptMapper;
import com.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept findById(Integer deptNo) {
        return deptMapper.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }
}

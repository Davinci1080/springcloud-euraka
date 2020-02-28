package com.itcast.service;

import com.atcast.entity.Dept;

import java.util.List;

public interface DeptService {
    Dept findById(Integer deptNo);

    List<Dept> findAll();

    boolean addDept(Dept dept);
}

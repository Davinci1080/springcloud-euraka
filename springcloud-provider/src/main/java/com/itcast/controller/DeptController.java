package com.itcast.controller;

import com.atcast.entity.Dept;
import com.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//responsebody是将java转换为json返回给请求者
//requestbody是将请求体里面的json转换为java的类型传进来
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value="/dept/add", method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {

        return deptService.addDept(dept);
    }

    @RequestMapping(value="/dept/get/{deptNo}", method=RequestMethod.GET)
    public Dept get(@PathVariable("deptNo") Integer deptNo) {
        return deptService.findById(deptNo);
    }

    @RequestMapping(value="/dept/get/all", method=RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.findAll();
    }
}

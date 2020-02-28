package com.itcast.controller;

import com.atcast.entity.Dept;
import com.itcast.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    //在主体方法出现问题时候调用的备用方法
    @HystrixCommand(fallbackMethod = "getHystrix1")
    @RequestMapping(value="/dept/get/{deptNo}", method=RequestMethod.GET)
    public Dept get(@PathVariable("deptNo") Integer deptNo) throws InterruptedException {
        if (deptNo == 999){
            throw new RuntimeException("该参数不合法");
        }
        if (deptNo == 555){
            Thread.sleep(5000);
        }

        return deptService.findById(deptNo);
    }

    //原主体方法熔断后调用的备用方法
    public Dept getHystrix1(@PathVariable("deptNo") Integer deptNo){
        return new Dept(deptNo,"没有从数据库里面获取到有效的数据测试springcloud的熔断hystrix","没有数据库");
    }

    @RequestMapping(value="/dept/get/all", method=RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.findAll();
    }
}

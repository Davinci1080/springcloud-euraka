package com.itcast.mapper;

import com.atcast.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//这个注解是为了 将来能够扫描到接口ioc的容器和spring的插件可以创建spring的bean
//然后才能是用@Autowired来装配mapper
//在springboot中使用的是MapperScan
@Mapper// 作用类似于@Service、@Controller注解。另一个方案是在主启动类上使用@MapperScan
public interface DeptMapper {

    Dept findById(Integer deptNo);

    List<Dept> findAll();

    boolean addDept(Dept dept);
}

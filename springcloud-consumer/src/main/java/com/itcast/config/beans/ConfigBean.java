package com.itcast.config.beans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //测试conparewithbirth
	@Bean
    @LoadBalanced//启用ribbon的负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
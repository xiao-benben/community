package com.newcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
		//这个方法会自动启动tomcat，然后创建IOC容器
		//自动扫描配置下的bean，装配到IOC容器中，
	}

}

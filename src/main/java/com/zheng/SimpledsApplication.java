package com.zheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zheng.mapper")
@SpringBootApplication
public class SimpledsApplication   {

	public static void main(String[] args) {
		SpringApplication.run(SimpledsApplication.class, args);
	}
}

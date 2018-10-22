package com.zheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.zheng.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class SimpledsApplication   {

	public static void main(String[] args) {
		SpringApplication.run(SimpledsApplication.class, args);
	}
}

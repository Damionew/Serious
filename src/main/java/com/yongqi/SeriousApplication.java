package com.yongqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yongqi.mapper")  /**开启自动扫描Mapper**/
public class SeriousApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriousApplication.class, args);
	}
}

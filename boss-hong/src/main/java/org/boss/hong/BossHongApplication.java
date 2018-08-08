package org.boss.hong;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.boss.hong.**.mapper", markerInterface =Mapper.class)
public class BossHongApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BossHongApplication.class, args);
	}

}

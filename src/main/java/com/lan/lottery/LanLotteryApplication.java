package com.lan.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lan.lottery.mapper"})
public class LanLotteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanLotteryApplication.class, args);
	}

}

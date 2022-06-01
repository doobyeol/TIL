package com.zerobase.fastlms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FastlmsApplication {

	// /논리적주소/물리적주소
	// 스프링 컨트롤러의 역할 : 실질적인 파일 = 논리적인 주소와 매핑


	public static void main(String[] args) {
		SpringApplication.run(FastlmsApplication.class, args);
	}

}

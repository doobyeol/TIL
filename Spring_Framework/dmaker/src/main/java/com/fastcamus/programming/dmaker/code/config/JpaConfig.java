package com.fastcamus.programming.dmaker.code.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // 데이터가 생성,수정될때 자동으로 기록
public class JpaConfig {
}

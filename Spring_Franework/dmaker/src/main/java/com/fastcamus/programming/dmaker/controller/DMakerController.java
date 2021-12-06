package com.fastcamus.programming.dmaker.controller;

import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController // 컨트롤러인데 자동으로 ResponseBody를 달아준다.
                // @Controller는 RestAPI를 입력받아 진입점으로 쓰겠다는 의미
                // 사실 컴포넌트와는 동일한 타입이다. (bean 등록)
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    // DMakerController(Bean)    DMakerService(Bean)  DeveloperRepository(Bean)
    // ===================== Spring Application Context =======================


    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow","elsa","olaf");
    }

    @GetMapping("/create-developers")
    public List<String> createDevelopers(){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /create-developers HTTP/1.1"); // 원래는 POST 쓰는것을 권장

        dMakerService.createDeveloper();

        return Collections.singletonList("olaf");
    }
}

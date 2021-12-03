package com.fastcamus.programming.dmaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController // 컨트롤러인데 자동으로 ResponseBody를 달아준다.
                // @Controller는 RestAPI를 입력받아 진입점으로 쓰겠다는 의미
                // 사실 컴포넌트와는 동일한 타입이다. (bean 등록)

public class DMakerController {
    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow","elsa","olaf");
    }
}

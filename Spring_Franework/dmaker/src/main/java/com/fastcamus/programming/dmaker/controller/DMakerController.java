package com.fastcamus.programming.dmaker.controller;

import com.fastcamus.programming.dmaker.dto.*;
import com.fastcamus.programming.dmaker.exception.DMakerException;
import com.fastcamus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    public List<DeveloperDto> getAllDevelopers(){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllEmployedDevelopers();
    }

    @GetMapping("/developer/{memberId}")  // http://localhost:8080/developer/Mini
    public DeveloperDetailDto getAllDeveloperDetail(
            @PathVariable final String memberId
    ){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /developer/memberId HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request // 요청값을 받아온다.
    ){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        // log.info("GET /create-developers HTTP/1.1"); // 원래는 POST 쓰는것을 권장
        /*
        try {
            return dMakerService.createDeveloper(request);
        }catch (Exception e){
            return xxx;
        } ---> @ExceptionHandler
        */
        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }

    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request // 요청값을 받아온다.
    ){
        // GET /developers HTTP/1.1 요청이 들어오면 여기 로직을 타게 된다.
        log.info("GET /developer/memberId edit HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);
    }


    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable String memberId
    ){
        return dMakerService.deleteDeveloper(memberId);
    }


}

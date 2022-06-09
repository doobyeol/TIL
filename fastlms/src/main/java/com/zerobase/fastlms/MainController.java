package com.zerobase.fastlms;

// MainPage 클래스를 만드는 목적
// 매핑 하기 위해서 !
// 주소 (논리적 주소와 인터넷 주소) 물리적인 파일을(프로그래밍을 위한) 매핑

// http://www.naver.com/new/list.do
// 하나의 주소에 대해서
// 어디서 매핑? 누가 매핑?
// 후보군 : 클래스(비효율적,탈락), 속성(용도가 다름), 메소드 (기능을 수행하는 메소드가 적절)
// http://localhost:8080/

import com.zerobase.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {

        String email = "doobyeol@gmail.com";
        String subject = "안녕하세요! 테스트 메일입니다.";
        String text = "<h1>안녕하세요!</h1><p>테스트 메일입니다!</p>";

//        mailComponents.sendMail(email, subject, text);

        return "index";
    }

    // 스프링 -> MVC (VIEW -> 템플릿 엔진 화면에 내용을 출력 (html))
    // .NET -> MVC (VIEW -> 출력)
    // python django -> MVC (Template -> 화면출력)
    // 백엔드 과정 -> VIEW -> 프론트엔드 과정
    // V -> HTML => 웹페이지
    // V -> json => API


    // request -> WEB -> SERVER
    // response -> SERVER -> WEB

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<p>hello</p>" +
                "<p>fastlms website!</p>" +
                "<p>안녕요</p>" +
                "</body>" +
                "</html>";

        printWriter.write(msg);
        printWriter.close();

    }

}

package study.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/template1")
    public String template1Page() {
        // 여기서 반환하는 문자열 "template1"은 응답 메시지의 바디에 포함될 문자열이 아니고, 렌더링할 파일의 이름("template1.html")임을 유의
        return "template1";
    }
}

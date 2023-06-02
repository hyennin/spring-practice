package study.cookie_session;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionTestController {
    @PostMapping("/add_session_data")
    public String addSessionData(@RequestParam Map<String, String> params, HttpSession session) {
        for(String key : params.keySet()) {
            session.setAttribute(key, params.get(key));
        }
        // 세션 timeout 시간 설정 (단위는 초)
        // 쿠키와는 다르게 특정 시간에 반드시 만료되는 개념이 아니고, 매 요청시마다 만료 시간이 연장되는 개념으로 이해
        session.setMaxInactiveInterval(60);

        return "success";
    }
}

package study.mvc;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyController {

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @GetMapping("/hello")
    public void hello(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setHeader("Content-Type", "text/plain; charset=utf-8");
        response.setHeader("Content-Length", "5");
        response.getWriter().write("Hello");
    }

    @GetMapping("/echo")
    public void echo(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String method = request.getMethod();
        System.out.println("Method : " + method);

        String uri = request.getRequestURI();
        System.out.println("URI : " + uri);

        String queryString = request.getQueryString();
        System.out.println("query String : " + queryString);

        HashMap<String, String> map = new HashMap<>();
        String[] parts = queryString.split("&");
        for(String p : parts) {
            String[] pair = p.split("=");
            map.put(pair[0], pair[1]);
        }

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String protocol = request.getProtocol();
        System.out.println("protocol : " + protocol);
    }
}
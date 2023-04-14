package study.mvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

class SuccessResult {
    public String result = "success";
}

class Result {
    public String result;
    public Integer code;
}

@RestController
@RequestMapping("/test")
public class TestController {
    private int cnt = 0;

    // Q1 "Hello, World! 텍스트 출력하기
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloWorld() {
        return "Hello, World!";
    }

    // Q2 쿼리 스트링 reverse 하기
    @GetMapping(value = "/concat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String reverseString(@RequestParam(value = "words", defaultValue = "") String words) {
        String[] wordString = words.split(",");
        String res ="";
        for (int i = wordString.length-1; i >= 0; i--) {
            if (i != 0)
                res = res + (wordString[i].trim()) + ",";
            else res = res + (wordString[i].trim());
        }

        return res;
    }

    // Q3 RequestParam 써서 두 숫자 곱한 결과 출력하기
    @GetMapping(value = "/mul", produces = MediaType.TEXT_PLAIN_VALUE)
    public String multiplyTwoNumbers(
            @RequestParam(value = "num1") Integer num1,
            @RequestParam(value = "num2") Integer num2) {
        return "" + num1 * num2;
    }

    // Q4 PathVariable, RequestParam 써서 두 숫자 연산 결과 출력하기
    @GetMapping(value = "/calc/{op}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String basicCalculator(
            @PathVariable("op") String op,
            @RequestParam(value = "num1") Integer num1,
            @RequestParam(value = "num2") Integer num2
    ) throws Exception {

        switch (op) {
            case "add" : return "" + (num1 + num2);
            case "sub" : return "" + (num1 - num2);
            case "mul" : return "" + (num1 * num2);
            default: throw new Exception("잘못된 연산자");
        }
    }

    // Q5 메서드가 호출된 횟수 반환
    @PostMapping(value = "/count", produces = MediaType.TEXT_PLAIN_VALUE)
    public String countRequest() {
        return "" + (++cnt);
    }

    @GetMapping(value = "/result1", produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessResult resultTest1() {
        return new SuccessResult();
    }

    @GetMapping(value = "/result2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result resultTest2() {
        Result result = new Result();
        result.result = "success";
        result.code = 1000;

        return result;
    }

    @GetMapping(value = "/result3", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> resultTest3() {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("code", 1000);

        return result;
    }

    @GetMapping(value = "/now", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> nowTest() {
        Map<String, Object> result = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        result.put("date", dateFormat.format(date));
        result.put("time", timeFormat.format(date));

        return result;
    }
}

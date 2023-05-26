// 3411 최혜민
package study.mvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

class Person {
    public String name;
    public Integer age;
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 힌트) 두 객체의 논리적 비교를 위해서 게터나 equals 메서드 이용 가능
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

class ReqJson {
    public String str1;
    public String str2;
}

class ResJson {
    public String result;
}

@RestController
public class Controller3411 {
    // Q1)
    @GetMapping(value = "/make-person/{name}/{age}")
    public void makePerson(
        @PathVariable("name") String name,
        @PathVariable("age") Integer age
    ) {
        Person p = new Person();
        p.name = name;
        p.age = age;
        System.out.println(p);
    }

    // Q2
    @GetMapping(value = "/check-even")
    public Boolean checkEven(
        @RequestHeader("X-Number") Integer num
    ) {
        if (num % 2 == 0) return true;
        else return false;
    }

    // Q3
    @PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
    public String login(
        @RequestParam(value = "username") String username,
        @RequestParam(value = "password") String password
    ) {
        User userData = new User("admin", "1234");
        User currentUserData = new User(username, password);

        if(userData.equals(currentUserData)) return "success";
        else return "fail";
//        if(currentUserData.getUsername().equals(userData.getUsername()) && currentUserData.getPassword().equals(userData.getPassword())) return "success";
//        else return "fail";
    }

    // Q4
    @PostMapping(value = "/concat", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResJson concat(
        @RequestBody ReqJson reqJson
    ) {
        ResJson resJson = new ResJson();
        resJson.result = reqJson.str1.concat(reqJson.str2);

        return  resJson;
    }
}
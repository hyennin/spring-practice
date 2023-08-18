// 3411 최혜민
package com.example.study_jpa.Controller;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/dict")
public class DictController {
    private HashMap<String, String> dict = new HashMap<>();

    @PostMapping("/{eng}/{kor}")
    public HashMap<String, String> postDict(@PathVariable("eng") String eng, @PathVariable("kor") String kor) {
        dict.put(eng, kor);
        return dict;
    }

    @ResponseBody
    @GetMapping("/{eng}")
    public String getDict(@PathVariable("eng") String eng) {
        if(dict.containsKey(eng)) {
            return dict.get(eng);
        } else {
            return null;
        }
    }

    @ResponseBody
    @PatchMapping("/{eng}")
    public String patchDict(@PathVariable("eng") String eng, @RequestParam("kor") String kor) {
        if(dict.containsKey(eng)) {
            dict.put(eng, kor);
            return "OK";
        } else {
            return "fail";
        }
    }

    @ResponseBody
    @DeleteMapping("/{eng}")
    public String deleteDict(@PathVariable("eng") String eng) {
        if(dict.containsKey(eng)) {
            dict.remove(eng);
            return "OK";
        } else {
            return "fail";
        }
    }
}

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Dictionary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NonNull
    private String eng;

    @Column
    private String kor;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Transient
    private Integer extra;
}
package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Nahyun";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?
    // name=Nahyun&
    // email=ksknh7@naver.com&
    // organization=hanyang
    @GetMapping(value = "/request1")
    public String getRequestParam1 (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization ) {
        return name + " " + email + " " + organization;
    }

    // 어떤 값이 들어올 지 정해져있지 않은 경우
    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2 (@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");

        });
        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?
    // name=Nahyun&
    // email=ksknh7@naver.com&
    // organization=hanyang
    @GetMapping(value = "/request3")
    public String getRequestParam3 (MemberDTO memberDTO) {
//         return memberDTO.getName() + " " + memberDTO.getEmail() + " " + ...;
        return memberDTO.toString();
    }



}

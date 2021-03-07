package org.bloggers.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller :
 * 스프링 패키지 이하를 스캔해서 모든 파일을 메모리에 new하는것이 아니고
 * 특정 어노테이션이 붙어 있는 클래스 파일들을 new해서 IoC 스프링 컨테이너에 관리
 */
@RestController
public class TestController {
    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>hellp spring boot</h1>";
    }
}


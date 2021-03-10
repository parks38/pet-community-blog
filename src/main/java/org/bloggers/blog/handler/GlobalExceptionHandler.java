package org.bloggers.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * controllerAdvice : 어디에서든 exception이 생긴다면 이 페이지로 데리고 온다.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    /**
     *  value - 원하는 익셉션 타입
     *  Exception.class - 모든 익셉션 받기
     */
    @ExceptionHandler(value = Exception.class)
    public String handleArgumentException(Exception e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }

}

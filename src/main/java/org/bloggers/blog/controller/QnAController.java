package org.bloggers.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController {

    //user 권한 필요
    @GetMapping("/qna")
    public String qnaBulletin() {
        return "qna/qna";
    }


    
}

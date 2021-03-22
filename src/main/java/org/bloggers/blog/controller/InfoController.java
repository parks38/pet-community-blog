package org.bloggers.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    //user 권한 필요
    @GetMapping("/info")
    public String infoBulletin() {
        return "board/infoBulletin";
    }


    
}

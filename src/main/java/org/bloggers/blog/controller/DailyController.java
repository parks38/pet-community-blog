package org.bloggers.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DailyController {

    //user 권한 필요
    @GetMapping("/daily")
    public String dailyBulletin() {
        return "daily/dailyBulletin";
    }


    
}

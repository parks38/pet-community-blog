package org.bloggers.blog.controller;

import org.bloggers.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyPetPostController {

    //user 권한 필요
    @GetMapping("/mypet")
    public String petBulletin() {
        return "mypet/mypetBulletin";
    }


    
}

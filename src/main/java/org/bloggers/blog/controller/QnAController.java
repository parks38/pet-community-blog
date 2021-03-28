package org.bloggers.blog.controller;

import org.bloggers.blog.service.BoardService;
import org.bloggers.blog.service.QnAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QnAController {
    @Autowired
    private QnAService qnAService;


    //user 권한 필요
    @GetMapping("/qna")
    public String qnaBulletin(Model model, @PageableDefault(size = 10, sort = "id",
        direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("questions", qnAService.글목록(pageable));
        return "qna/qna";
    }

}

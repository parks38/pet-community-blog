package org.bloggers.blog.controller;

import org.bloggers.blog.config.auth.PrincipalDetail;
import org.bloggers.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
    // 컨트롤러에서 세션 찾기 : @AuthenticationPrincipal PrincipalDetail principal
    public String index(Model model,
                        @PageableDefault(size = 3, sort = "id",
                                direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "index";
    }

    //user 권한 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board",boardService.글상세보기(id) );
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board",boardService.글상세보기(id) );
        return"board/updateForm";
    }

}

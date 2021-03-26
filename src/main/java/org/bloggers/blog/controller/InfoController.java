package org.bloggers.blog.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping({"","/"})
    // 컨트롤러에서 세션 찾기 : @AuthenticationPrincipal PrincipalDetail principal
    public String index(Model model,
        @PageableDefault(size = 3, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable) {
        //model.addAttribute("boards", boardService.글목록(pageable));
        return "index";
    }

    
}

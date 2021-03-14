package org.bloggers.blog.controller;

import org.bloggers.blog.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"})
    // 컨트롤러에서 세션 찾기 : @AuthenticationPrincipal PrincipalDetail principal
    public String index() {
        // /WEB-INF/views/
        //System.out.println("로그읹 사ㅑ용자 아이디: " + principal.getUsername());
        return "index";
    }

    //user 권한 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}

package org.bloggers.blog.controller.api;

import org.bloggers.blog.dto.ResponseDto;
import org.bloggers.blog.model.RoleType;
import org.bloggers.blog.model.User;
import org.bloggers.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출됨 ");
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

}

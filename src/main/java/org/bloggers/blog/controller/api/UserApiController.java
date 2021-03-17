package org.bloggers.blog.controller.api;

import org.bloggers.blog.dto.ResponseDto;
import org.bloggers.blog.model.User;
import org.bloggers.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출됨 ");
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) { //json (key-value)
        userService.회원수정(user);
        //세션 등록
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

}

package org.bloggers.blog.service;

import org.bloggers.blog.model.User;
import org.bloggers.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @Service : 스프링이 컴포넌트 스캔을 통해서 Bean 에 등록해줌. IoC 해줌
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /* 성공하면 commit 실패하면 rollback*/
    @Transactional
    public int 회원가입(User user) {
        try{
            userRepository.save(user);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService: 회원가입()" + e.getMessage());
        }
        return -1;
    }
}

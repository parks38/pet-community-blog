package org.bloggers.blog.service;

import org.bloggers.blog.model.RoleType;
import org.bloggers.blog.model.User;
import org.bloggers.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @Service : 스프링이 컴포넌트 스캔을 통해서 Bean 에 등록해줌. IoC 해줌
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;



    /* 성공하면 commit 실패하면 rollback*/
    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);

    }

    @Transactional
    public void 회원수정 (User user) {
        /**
         * 회원 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화 시키고,
         * 영속화된 USer 오브젝트를 수정
         * select를 해서 USer 오브젝트를 DB로부터 가져오는 이유는 영속화를 하기 위해서!!
         * 영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날려주거든요
         */
        User persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("회원 찾기 실패");
        });

        //validation check : oauth 에 필드값없으면 수정가능
        if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            persistance.setPassword(encPassword);
            persistance.setEmail(user.getEmail());
        }


        //회원 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit 자동
        //영속화된 persistance객체의 변화가 감지되면 더티체킹이 되어 update 문 날려줌.

    }

    @Transactional(readOnly = true)
    public User 회원찾기(String username) {
        User user =userRepository.findByUsername(username).orElseGet(User::new);
        return user;
    }


}

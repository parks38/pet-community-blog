package org.bloggers.blog.controller;

import org.bloggers.blog.model.RoleType;
import org.bloggers.blog.model.User;
import org.bloggers.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

// data를 리턴해주는 controller
@RestController
public class UserController {
    @Autowired //의존성 주입
    private UserRepository userRepository;
    /**
     * http의 body에 username, password, email 데이터를 가지고 요청
     * @RequestParam("username") String user : 변수명을 정확하게 적으면 타입으로 받을수 있다.
     */
    @PostMapping("/user/join") // key = value (약속된 규칙)
    public String join(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getId());
        System.out.println(user.getRole());
        System.out.println(user.getCreateDate());

        user.setRole(RoleType.USER);

        userRepository.save(user);

        return "회원가입이 완료되었습니다. ";
    }

    // {id} 주소로 파라미터를 전달 받을 수 있음
    @GetMapping("/user/{id}")
    public User detail(@PathVariable int id) {

        User user = userRepository.findById(id).orElseThrow(() -> {
            // null 이면 빈객체를 리턴해 준다
            return new IllegalArgumentException("유저가 존재하지 않습니다. ");
        });

        return user;
    }

    @GetMapping("/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    /**
     * 한페이지 당 2건에 데이터를 리턴받아볼 예정
     * size = 몇개의 건을 들고올건지
     * sort = id로
     * Sort.Direction.DESC = 최신순
     * @param pageable
     */
    @GetMapping("/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);
        //if(pagingUser.isLast()){  }
        List<User> users = pagingUser.getContent();
        return users;
    }

    /**
     * update : email , password 수정 가능
     * json data 를 받기 -> @RequestBody
     */
    @Transactional
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id: " + id);
        System.out.println("password : " + requestUser.getPassword());
        System.out.println("email : " + requestUser.getEmail());
        User user = userRepository.findById(id).orElseThrow(() ->{
           return new IllegalArgumentException("수정에 실패했습니다. ");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        return null;
    }
}

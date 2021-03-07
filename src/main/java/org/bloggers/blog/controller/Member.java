package org.bloggers.blog.controller;

import lombok.*;

//@Getter
//@Setter
@Data //getter setter
//@AllArgsConstructor // 생성자
//@RequiredArgsConstructor - final 에 대한 생성자
@NoArgsConstructor // 빈생성자
public class Member {
    private Long id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

package org.bloggers.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM : Java (다른언어) Object -> 테이블로 매핑해주는 기술
@Entity //user class를 통해서 entity 읽어서 mysql 에 생성
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //프로젝트에서 연결된 db 의 넘버링 전략을 따라간다. -oracle:sequence / mysql : AI
    private int id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100) // 해쉬 암호화
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum 쓰는게 좋다. {admin, user, manager}

    @CreationTimestamp //시간자동 입력
    private Timestamp createDate;
}

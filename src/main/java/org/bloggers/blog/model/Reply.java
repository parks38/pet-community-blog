package org.bloggers.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    //어느 게시글에 있는 답변에 대한 연관관계 N:1
    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;

}

package org.bloggers.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
    private int id;
    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //summer note library tool <html> 태그 섞어서 디자인

    private int count; //조회수

    @CreationTimestamp
    private LocalDateTime createDate;

    //연관관계
    @ManyToOne(fetch = FetchType.EAGER) // many = board, one = user
    @JoinColumn(name="userId")
    private User user; //작성자 - db 오브젝트를 저장할수 없다

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // reply Board 가 FK
    @JsonIgnoreProperties({"board"})
    @OrderBy("id desc")
    private List<Reply> replys;
}

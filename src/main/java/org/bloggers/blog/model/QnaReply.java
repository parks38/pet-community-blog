package org.bloggers.blog.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QnaReply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
  private int id;

  @Column(nullable = false, length = 200)
  private String content;

  //어느 게시글에 있는 답변에 대한 연관관계 N:1
  @ManyToOne
  @JoinColumn(name = "qnaId")
  private QnA qna;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  @CreationTimestamp
  private Timestamp createDate;
}

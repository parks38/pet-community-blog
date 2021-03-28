package org.bloggers.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class QnA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Lob
  private String content;

  @CreationTimestamp
  private LocalDateTime createDate;

  //연관관계
  @ManyToOne(fetch = FetchType.EAGER) // many = board, one = user
  @JoinColumn(name="userId")
  private User user; //작성자 - db 오브젝트를 저장할수 없다

  @OneToMany(mappedBy = "qna", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // reply Board 가 FK
  @JsonIgnoreProperties({"qna"})
  @OrderBy("id desc")
  private List<QnaReply> qnaReplys;





}

package org.bloggers.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaReplySaveRequestDto {
    private int userId;
    private int postId;
    private String content;
}

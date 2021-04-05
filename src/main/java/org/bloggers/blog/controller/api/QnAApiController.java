package org.bloggers.blog.controller.api;

import org.bloggers.blog.config.auth.PrincipalDetail;
import org.bloggers.blog.dto.QnaReplySaveRequestDto;
import org.bloggers.blog.dto.ReplySaveRequestDto;
import org.bloggers.blog.dto.ResponseDto;
import org.bloggers.blog.model.Board;
import org.bloggers.blog.model.QnA;
import org.bloggers.blog.service.BoardService;
import org.bloggers.blog.service.QnAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QnAApiController {
    @Autowired
    private QnAService qnAService;

    @PostMapping("/api/qna")
    public ResponseDto<Integer> save(@RequestBody QnA qna,
                                     @AuthenticationPrincipal PrincipalDetail principal){
        qnAService.글쓰기(qna, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

    @DeleteMapping("/api/qna/{id}")
    public ResponseDto<Integer> deletedById(@PathVariable int id) {
        qnAService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

    @PostMapping("/api/qna/{qnaId}/reply")
    public ResponseDto<Integer> replySave(@RequestBody QnaReplySaveRequestDto replySaveRequestDto){
        qnAService.댓글쓰기(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

    @DeleteMapping("/api/qna/{qnaId}/reply/{qnareplyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int qnareplyId) {
        qnAService.댓글삭제(qnareplyId);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

}

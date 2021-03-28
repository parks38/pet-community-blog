package org.bloggers.blog.service;

import org.bloggers.blog.dto.ReplySaveRequestDto;
import org.bloggers.blog.model.Board;
import org.bloggers.blog.model.QnA;
import org.bloggers.blog.model.User;
import org.bloggers.blog.repository.BoardRepository;
import org.bloggers.blog.repository.QnARepository;
import org.bloggers.blog.repository.QnaReplyRepository;
import org.bloggers.blog.repository.ReplyRepository;
import org.bloggers.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QnAService {
    @Autowired
    private QnaReplyRepository qnaReplyRepository;

    @Autowired
    private QnARepository qnARepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void 글쓰기(QnA qna, User user) { // title , content
        qna.setUser(user);
        qnARepository.save(qna);
    }

    @Transactional(readOnly = true)
    public Page<QnA> 글목록(Pageable pageable) {
        return qnARepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public QnA 글상세보기(int id) {
        return qnARepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다. ");
                });
    }

    @Transactional
    public void 글삭제하기(int id) {
        qnARepository.deleteById(id);
    }


    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
        int result = qnaReplyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println("qnaService: " + result);
    }

    @Transactional
    public void 댓글삭제(int replyId) {
        qnaReplyRepository.deleteById(replyId);
    }

}

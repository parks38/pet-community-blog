package org.bloggers.blog.repository;

import org.bloggers.blog.model.Board;
import org.bloggers.blog.model.QnA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnARepository extends JpaRepository<QnA, Integer> {
}

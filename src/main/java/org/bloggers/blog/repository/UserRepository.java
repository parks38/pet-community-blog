package org.bloggers.blog.repository;

import org.bloggers.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User 타입이고 Integer 이다.
 * JpaRepository : findAll 이라는 함수를 가지고 있다.
 * JSP - DAO
 * 자동으로 bean으로 등록
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

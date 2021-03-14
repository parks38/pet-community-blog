package org.bloggers.blog.repository;

import org.bloggers.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // select * from user where username = 1?
    Optional<User> findByUsername(String username);
}

package com.cmpt276_cs_prof_rate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmpt276_cs_prof_rate.demo.models.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserId(int userId);
}

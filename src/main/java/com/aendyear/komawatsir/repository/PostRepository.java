package com.aendyear.komawatsir.repository;

import com.aendyear.komawatsir.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

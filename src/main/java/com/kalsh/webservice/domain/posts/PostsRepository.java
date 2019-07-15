package com.kalsh.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /* ibatis/MyBatis 등에서 'Dao' 라고 불리는 DB Layer 접근자.
     * JPA 에선 Repository 라고 부르며, 인터페이스로 생성!!!!!
     * JpaRepository<Entity클래스, pk타입> 을 상속하면,
       기본적인 CRUD 메소드가 자동으로 생성됨
     */

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}

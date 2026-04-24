package com.hangyo.boardapp.repository;

import com.hangyo.boardapp.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 메서드 이름으로 해결 못하는 복잡한 쿼리 직접 작성 ( JPA )
    // writer가 일치하고, title에 keyword 단어가 포함된 게시글 조회
    @Query("select b From Board b Where b.writer = :writer AND b.title Like %:keyword%")
    List<Board> search(
            @Param("writer") String writer,     // 작성자 조건
            @Param("keyword") String keyword);  // 제목 검색 키워드
}

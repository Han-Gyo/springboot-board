package com.hangyo.boardapp.repository;

import com.hangyo.boardapp.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 메서드 이름으로 해결 못하는 복잡한 쿼리 직접 작성 ( JPA )
    // writer가 일치하고, title에 keyword 단어가 포함된 게시글 조회
    /* @Query("select b From Board b Where b.writer = :writer AND b.title Like %:keyword%")
    List<Board> search(
            @Param("writer") String writer,     // 작성자 조건
            @Param("keyword") String keyword);  // 제목 검색 키워드 */


    // 작성자와 제목 키워드로 게시글 검색 + 페이징
    @Query("select b from Board b where b.writer = :writer and b.title like %:keyword%")
    Page<Board> search(@Param("writer") String writer,
                       @Param("keyword") String keyword,
                       Pageable pageable);
}

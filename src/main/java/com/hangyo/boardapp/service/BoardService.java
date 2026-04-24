package com.hangyo.boardapp.service;

import com.hangyo.boardapp.Mapper.BoardMapper;
import com.hangyo.boardapp.entity.Board;
import com.hangyo.boardapp.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    // 저장
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    // 전체 조회
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    // 단일 조회
    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
    }

    // 삭제
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    // 수정
    public Board update(Long id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));

        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        board.setWriter(requestBoard.getWriter());

        return boardRepository.save(board);
    }

    /* 작성자와 제목 키워드로 게시글 검색
    public List<Board> search(String writer, String keyword) {
        return boardRepository.search(writer, keyword);
    } */

    // 게시글 목록 페이징 조회
    public Page<Board> findAllPaging(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 작성자와 제목 키워드로 게시글 검색 + 페이징
    public Page<Board> search(String writer, String keyword, Pageable pageable) {
        return boardRepository.search(writer, keyword, pageable);
    }
}
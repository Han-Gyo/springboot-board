package com.hangyo.boardapp.controller;


import com.hangyo.boardapp.entity.Board;
import com.hangyo.boardapp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 테스트용 데이터 저장
    @GetMapping("/test")
    @ResponseBody
    public String test(){

        Board board = new Board();
        board.setTitle("제목1");
        board.setContent("내용1");
        board.setWriter("작성자1");

        boardService.save(board);

        return "저장 완료" ;
    }
    
    // 게시글 목록 조회 + 페이징
    @GetMapping("/boards")
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {

        Page<Board> boardPage = boardService.findAllPaging(PageRequest.of(page,5));

        model.addAttribute("boards", boardPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boardPage.getTotalPages());

        return "list";
    }

    // 단일 조회 read_one
    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "detail";
    }

    // 삭제
    @GetMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id) {

        boardService.deleteById(id);

        return "redirect:/boards";
    }

    // 수정 화면 요청
    @GetMapping("/boards/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "edit";
    }

    // 수정 처리
    @PostMapping("/boards/update/{id}")
    public String update(@PathVariable Long id, Board board){
        boardService.update(id, board);
        return "redirect:/boards/" + id;
    }

    // 글쓰기 화면 요청
    @GetMapping("/boards/write")
    public String writeForm() {
        return "write";
    }

    // 게시글 저장
    @PostMapping("/boards/write")
    public String write(Board board) {
        boardService.save(board);
        return "redirect:/boards";
    }

    // 게시글 검색 API
    // 예) /boards/search?writer=작성자1&keyword=제목
    /* @GetMapping("/boards/search")
    @ResponseBody
    public List<Board> search(@RequestParam String writer,
                              @RequestParam String keyword) {
        return boardService.search(writer, keyword);
    } */

    // 게시글 검색 + 페이징
    @GetMapping("/boards/search")
    public String search(@RequestParam String writer,
                         @RequestParam String keyword,
                         @RequestParam(defaultValue = "0") int page,
                         Model model) {
        Page<Board> boardPage = boardService.search(writer, keyword, PageRequest.of(page, 5));

        model.addAttribute("boards", boardPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boardPage.getTotalPages());
        model.addAttribute("writer", writer);
        model.addAttribute("keyword", keyword);

        return "list";
    }
}

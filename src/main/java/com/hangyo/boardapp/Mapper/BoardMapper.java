package com.hangyo.boardapp.Mapper;


import com.hangyo.boardapp.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 전체조회
    @Select("SELECT * FROM board")
    List<Board> findAll();

}

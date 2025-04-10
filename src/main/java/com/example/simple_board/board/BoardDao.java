package com.example.simple_board.board;

import org.apache.ibatis.annotations.*;

@Mapper
public interface BoardDao {

  // @SelectKey로 생성한 글번호를 리턴하는 save


  // 글 전체를 리턴하는 findAll


  // 글 1개를 리턴하는 findByBno


  // 글 조회수를 증가하는 increaseReadCnt


  // 제목과 글 내용을 업데이트하는 update


  // 글을 삭제하는 delete
}

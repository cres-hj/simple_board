package com.example.simple_board.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface BoardDao {

  // @SelectKey로 생성한 글번호를 리턴하는 save
  @SelectKey(statement = "select boards_seq.nextval from dual", keyProperty = "bno", resultType = Integer.class, before=true)
  @Insert("insert into boards(bno, title, content, nickname, password) values(#{bno}, #{title}, #{content}, #{nickname}, #{password})")
  public int save(Board board);


  // 글 전체를 리턴하는 findAll
  @Select("select * from boards order by bno desc")
  public List<Board> findAll();


  // 글 1개를 리턴하는 findByBno
  @Select("select * from boards where bno=#{bno}")
  public Board findByBno(Integer bno);


  // 글 조회수를 증가하는 increaseReadCnt
  @Update("update boards set read_cnt=read_cnt+1 where bno=#{bno}")
  public int increaseReadCnt(Integer bno);


  // 제목과 글 내용을 업데이트하는 update
  @Update("update boards set title = #{title}, content=#{content} where bno=#{bno}")
  public int update(Board board);

  // 글을 삭제하는 delete
  @Delete("delete from boards where bno=#{bno}")
  public int delete(int bno);
}

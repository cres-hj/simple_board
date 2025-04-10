package com.example.simple_board.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface CommentDao {
  // 추가 (selectkey 필요 없어)
  @Insert("insert into comments values(comments_seq.nextval, #{content}, #{nickname}, #{password}, sysdate, #{bno})")
  int save(Comment comment);

  // 삭제 by Cno
  @Delete("delete from comments where cno=#{cno} and rownum=1")
  int deleteByCno(int cno);

  // 삭제 by Bno (글을 삭제하면 그 글의 댓글도 날아가게. 원래는 글 삭제 안하고 비활성화야)
  // 오라클 hint를 이용했어 (rownum 사용)
  // Board 글을 삭제하면 이거도 실행되어야해 => 이건 BoardService가 가지고 가
  @Delete("delete from comments where bno=#{bno}")
  int deleteByBno(int bno);

  // 목록(어떤 글을 주고 그 글에 종속된 댓글 다 출력해라)
  @Select("select * from comments where bno=#{bno}")
  List<Comment> findByBno(int bno);
}

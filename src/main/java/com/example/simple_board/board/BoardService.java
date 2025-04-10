package com.example.simple_board.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardService {
  @Autowired
  private BoardDao boardDao;
  @Autowired
  private CommentDao commentDao;

  // 글을 저장하고 글 번호를 리턴하는 save
  public int save(Board board) {
    boardDao.save(board);
    return board.getBno();
  }


  // 모든 글을 리턴하는 findAll
  public List<Board> findAll() {
    return boardDao.findAll();
  }


  // 하나의 글을 리턴하는 findByBno
  // Map 사용했으니까 타입 바꿔줌 (object에는 뭐든 담길 수 있어)
  public Map<String, Object> findByBno(int bno) {
    boardDao.increaseReadCnt(bno);  // 주의
    Board board = boardDao.findByBno(bno);
    List<Comment> comments = commentDao.findByBno(bno);
    // {"board":board, "comments", comments}파이썬의 딕셔너리에 해당하는게 자바의 Map
    return Map.of("board", board, "comments", comments);
  }


  // 글을 변경하는 update
  // 1. 사용자로 부터 글번호, 제목, 내용, 비밀번호를 전달받아
  // 2. 저장된 글의 비밀번호와 사용자가 입력한 비밀번호가 불일치하면 변경 실패 -> false 리턴
  // 3. 일치하는 경우 글을 변경한 다음 결과를 boolean으로 리턴
public boolean update(Board board) {
    String storedPassword = boardDao.findByBno(board.getBno()).getPassword();
    if(storedPassword.equals(board.getPassword())) {
      boardDao.update(board);  // 이 부분 안적어서 왜 업데이트 안되는거지 하고 헤맸어
      return true;
    }
    return false;
}


  // 글을 삭제하는 delete
  // 1. 사용자로 부터 글번호, 비밀번호를 전달받아
  // 2. 저장된 글의 비밀번호와 사용자가 입력한 비밀번호가 불일치하면 삭제 실패 -> false 리턴
  // 3. 일치하는 경우 글을 삭제한 다음 결과를 boolean으로 리턴
  public boolean delete(int bno, String password) {
    String storedPassword = boardDao.findByBno(bno).getPassword();
    if(storedPassword.equals(password)) {
      boardDao.delete(bno);
      commentDao.deleteByBno(bno);  // comment 작업하면서 추가
      return true;
    }
    return false;
  }


}

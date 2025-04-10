package com.example.simple_board.board;

public class BoardService {

  // 글을 저장하고 글 번호를 리턴하는 save


  // 모든 글을 리턴하는 findAll


  // 하나의 글을 리턴하는 findByBno


  // 글을 변경하는 update
  // 1. 사용자로 부터 글번호, 제목, 내용, 비밀번호를 전달받아
  // 2. 저장된 글의 비밀번호와 사용자가 입력한 비밀번호가 불일치하면 변경 실패 -> false 리턴
  // 3. 일치하는 경우 글을 변경한 다음 결과를 boolean으로 리턴


  // 글을 삭제하는 delete
  // 1. 사용자로 부터 글번호, 비밀번호를 전달받아
  // 2. 저장된 글의 비밀번호와 사용자가 입력한 비밀번호가 불일치하면 삭제 실패 -> false 리턴
  // 3. 일치하는 경우 글을 삭제한 다음 결과를 boolean으로 리턴


}

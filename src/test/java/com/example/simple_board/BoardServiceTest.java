package com.example.simple_board;

import com.example.simple_board.board.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardServiceTest {
  @Autowired
  private BoardService boardService;

  // @Test
  public void saveTest() {
    Board board = new Board(0, "떡볶이", "먹고싶다", "이복덕", "1234", null, 0);
    boardService.save(board);
    System.out.println(board);
  }

  // @Test
  public void findByBnoTest() {
    Board result = boardService.findByBno(2);
    System.out.println(result);
    assertNotNull(result);
  }

  // @Test
  public void findAllTest() {
    assertNotNull(boardService.findAll());
  }

  @Transactional
  // @Test
  public void updateSuccessTest() {
    // 통째로 새로 만들어서 변경
    Board board = Board.builder().bno(2).title("변경떡볶이").content("먹고싶어용").password("1234").build();
    boolean result = boardService.update(board);
    assertEquals(true, result);
  }

  @Transactional
  // @Test
  public void updateFailTest() {
    Board board = Board.builder().bno(2).title("변경떡볶이").content("먹고싶어용").password("1111").build();
    boolean result = boardService.update(board);
    assertEquals(false, result);
  }

  @Transactional
  // @Test
  public void deleteSuccessTest() {
    assertEquals(true, boardService.delete(2, "1234"));
  }

  @Transactional
  //@Test
  public void deleteFailTest() {
    assertEquals(false, boardService.delete(2, "1111"));
  }

}

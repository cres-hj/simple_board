package com.example.simple_board.board;

import lombok.*;

import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@Builder // 긴가민가했는데 update하려면 있어야해
@NoArgsConstructor
@ToString
public class Board {
  // bno, title, content, nickname, password, writetime, readcnt

  private Integer bno;
  private String title;
  private String content;
  private String nickname;
  private String password;
  private LocalDateTime writeTime;
  private Integer readCnt;
}

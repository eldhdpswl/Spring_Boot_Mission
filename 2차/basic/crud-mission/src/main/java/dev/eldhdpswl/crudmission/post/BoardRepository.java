package dev.eldhdpswl.crudmission.post;

import java.util.List;

public interface BoardRepository {
    boolean createBoard(BoardDto boardDto);
    List<BoardDto> findAllBoard();
    BoardDto findBoardById(int id);
    boolean updateBoard(int id, BoardDto boardDto);
    boolean deleteBoard(int id);
}

package dev.eldhdpswl.crudmission.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BoardRepositoryInMemory implements BoardRepository{

    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private final List<BoardDto> boardList;

    public BoardRepositoryInMemory() {
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean createBoard(BoardDto boardDto) {
        return this.boardList.add(dto);
    }

    @Override
    public List<BoardDto> findAllBoard() {
        return this.boardList.add(boardDto);
    }

    @Override
    public BoardDto findBoardById(int id) {
        return null;
    }

    @Override
    public boolean updateBoard(int id, BoardDto boardDto) {
        return false;
    }

    @Override
    public boolean deleteBoard(int id) {
        return false;
    }
}

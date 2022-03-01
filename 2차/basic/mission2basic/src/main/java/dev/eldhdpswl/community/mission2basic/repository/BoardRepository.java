package dev.eldhdpswl.community.mission2basic.repository;

import dev.eldhdpswl.community.mission2basic.model.BoardDto;

import java.util.Collection;

public interface BoardRepository {
    BoardDto create(BoardDto dto);
    BoardDto read(Long id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);

}

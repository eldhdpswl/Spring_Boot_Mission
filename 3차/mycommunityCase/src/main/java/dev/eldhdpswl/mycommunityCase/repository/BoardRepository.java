package dev.eldhdpswl.mycommunityCase.repository;


import dev.eldhdpswl.mycommunityCase.dto.BoardDto;
import dev.eldhdpswl.mycommunityCase.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
//    BoardDto create(BoardDto dto);
//    BoardDto read(Long id);
//    Collection<BoardDto> readAll();
//    boolean update(Long id, BoardDto dto);
//    boolean delete(Long id);

}

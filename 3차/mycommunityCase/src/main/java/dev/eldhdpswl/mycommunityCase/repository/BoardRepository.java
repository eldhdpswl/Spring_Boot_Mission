package dev.eldhdpswl.mycommunityCase.repository;


import dev.eldhdpswl.mycommunityCase.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}

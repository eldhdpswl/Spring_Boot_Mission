package dev.eldhdpswl.mycommunityCase.repository;

import dev.eldhdpswl.mycommunityCase.dto.PostDto;
import dev.eldhdpswl.mycommunityCase.dto.UserDto;
import dev.eldhdpswl.mycommunityCase.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

//    PostDto create(Long boardId, PostDto dto);
//    PostDto read(Long boardId, Long postId);
//    Collection<PostDto> readAll(Long boardId);
//    boolean update(Long boardId, Long postId, PostDto dto);
//    boolean delete(Long boardId, Long postId, String password);



}

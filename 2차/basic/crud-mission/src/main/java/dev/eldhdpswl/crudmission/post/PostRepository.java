package dev.eldhdpswl.crudmission.post;

import java.util.List;

public interface PostRepository {

    boolean save(PostDto dto);
    List<PostDto> findAll();
    PostDto findById(int id);
    boolean update(int id, PostDto dto);
    boolean delete(int id, String pw);


}

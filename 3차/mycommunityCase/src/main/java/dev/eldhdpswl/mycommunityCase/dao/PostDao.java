package dev.eldhdpswl.mycommunityCase.dao;

import dev.eldhdpswl.mycommunityCase.dto.PostDto;
import dev.eldhdpswl.mycommunityCase.entity.PostEntity;
import dev.eldhdpswl.mycommunityCase.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {

    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;

    public PostDao(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }

    public void createPost(PostDto dto){
        PostEntity postEntity = new PostEntity();

        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(dto.getWritter());
        postEntity.setBoardEntity(null);

        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id){

        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if(postEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();

    }

    public Iterator<PostEntity> readPostAll(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto dto){
        Optional<PostEntity> targetEntity = this.postRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();

        //dto.getTitle()이 null이면 기존에 원래있던 title(postEntity.getTitle()) 아니면 받아온 title(dto.getTitle())
        postEntity.setTitle(
                dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());

        //dto.getContent()이 null이면 기존에 원래있던 content(postEntity.getContent()) 아니면 받아온 title(dto.getContent())
        postEntity.setContent(
                dto.getContent() == null ? postEntity.getContent() : dto.getContent());

        // save는 create와 update에서 다 사용된다.
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());

    }



}

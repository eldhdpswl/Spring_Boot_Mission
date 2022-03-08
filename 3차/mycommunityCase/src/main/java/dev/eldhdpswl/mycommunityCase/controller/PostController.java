package dev.eldhdpswl.mycommunityCase.controller;



import dev.eldhdpswl.mycommunityCase.dto.PostDto;
import dev.eldhdpswl.mycommunityCase.repository.PostRepository;
import dev.eldhdpswl.mycommunityCase.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController

@RequestMapping("board/{boardId}/post") // 특정한 board안의 post를 찾는다라는 의미
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostRepository postRepository;
    private final PostService postService;

    public PostController(
            @Autowired PostRepository postRepository,
            @Autowired PostService postService
    ){
        this.postRepository = postRepository;
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody PostDto dto){
        // 파라미터에 @Valid를 사용하는 이유는 PostDto에서 valid를 확인을 해야된다는 것을 의미한다.
        this.postService.createPost(dto);
    }

    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        return this.postService.readPost(id);
    }

    @GetMapping("")
    public List<PostDto> readPostAll(){
        return this.postService.readPostAll();
    }


//    @GetMapping
//    public ResponseEntity<Collection<PostDto>> readPostAll(
//            @PathVariable("boardId") Long boardId){
//        Collection<PostDto> postList = this.postRepository.readAll(boardId);
//        if (postList == null) return ResponseEntity.notFound().build();
//        else return ResponseEntity.ok(postList);
//    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto dto
    ){
        this.postService.updatePost(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        this.postService.deletePost(id);
    }


}

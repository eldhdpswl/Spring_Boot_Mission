package dev.eldhdpswl.community.controller;

import dev.eldhdpswl.community.model.PostDto;
import dev.eldhdpswl.community.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*
# Spring Boot로 만드는 간단한 서비스

Spring Boot로 간단한 서비스를 만들어 봅시다.

## Basic Mission
커뮤니티 사이트 만들어보기
CRUD를 진행하면서 게시글을 만드는 API를 만들었습니다. 해당 내용을 좀더 구체적으로 구현해 봅시다.

1. 게시판에 대한 CRUD를 우선 작성합니다.
    1. 게시판은 게시판 이름에 대한 정보를 가지고 있어야 합니다.
2. 게시글에 대한 CRUD를 작성해 봅시다.
    1. 게시글에는 제목, 본문, 작성자, 비밀번호에 대한 정보가 존재합니다.
    2. 작성된 게시글은 게시판에 속해 있어야 합니다.
    3. 게시글을 삭제하기 위해서는 게시글의 비밀번호가 함깨 제공되어야 합니다.

### 세부 조건
1. 관계형 데이터베이스의 Primary Key와 같은 정보 데이터에 포함하여, 각 자원을 쉽게 식별할 수 있도록 합시다.
2. REST API와 URL의 구조를 잘 생각하여 `@RequestMapping` 구성을 할 수 있도록 합시다.
    1. 특히, `post` 와 `board` 의 관계가 요청하는 URL 상에 나타날 수 있도록 해봅시다.

----------------------------------------------------------------------------------------------
## Challenge Mission

게시글에 파일 첨부하기
베이직 미션의 커뮤니티를 만들때는 게시글에 오로지 문자만 입력이 가능합니다. 백엔드 서버의 관점에서, 게시글에 여러장의 사진을 첨부하거나, 파일을 첨부하는 기능을 만들어야 할때 어떻게 개발을 진행할지를 고민해 봅시다.

1. 웹페이지 상에서 게시글을 작성할 수 있는 서비스(예: 블로그) 중, 이미지가 작성되어 있는 게시글을 `F12` (Chrome Debugger)를 활용하여 HTML 문서를 분석해 봅시다.
2. Spring Boot로 보내진 `multipart/form-data` 의 요청에서 파일을 어떻게 저장할지를 고려해 봅시다.
3. HTML 문서에서, 이미지를 표현하기 위한 방법이 무엇인지를 고려해 봅시다.

### 세부 조건
1. 만들어야 하는것은 “사진을 여러장 업로드 할 수 있는 게시글을 작성하기 위한 ‘Backend Server’”입니다. 지나치게 복잡하게 생각하지 않도록 합시다.
2. 게시글을 만들기 위한 CRUD 작업 자체는 `Content-Type: application/json` 을 유지할 수 있도록 합시다.
3. 게시글을 제시할 웹 페이지에서는, 게시글의 content를 `HTML` 로 기대하고 있다고 가정합니다. 만약 Thymeleaf를 이용해 출력한다면, 아래와 유사한 형태의 태그를 사용하게 될것입니다.

* */



@RestController
/*
* 문제 세부조건
  2. REST API와 URL의 구조를 잘 생각하여 `@RequestMapping` 구성을 할 수 있도록 합시다.
    1. 특히, `post` 와 `board` 의 관계가 요청하는 URL 상에 나타날 수 있도록 해봅시다.
  그래서 "board/{boardId}/post" 이렇게 한다.
* */
@RequestMapping("board/{boardId}/post") // 특정한 board안의 post를 찾는다라는 의미
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostRepository postRepository;

    public PostController(@Autowired PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @PathVariable("boardId") Long boardId,
            @RequestBody PostDto dto
    ){
        PostDto result = this.postRepository.create(boardId, dto);
        return ResponseEntity.ok(result.passwordMasked());
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> readPost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId
    ){
        PostDto postDto = this.postRepository.read(boardId, postId);
        if (postDto == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postDto.passwordMasked());
    }

    @GetMapping
    public ResponseEntity<Collection<PostDto>> readPostAll(
            @PathVariable("boardId") Long boardId){
        Collection<PostDto> postList = this.postRepository.readAll(boardId);
        if (postList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postList);
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestBody PostDto dto
    ){
        if (!postRepository.update(boardId, postId, dto)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestParam("password") String password
    ){
        if (!postRepository.delete(boardId, postId, password)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();

    }


}

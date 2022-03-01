package dev.eldhdpswl.community.mission2basic.model;

/*
* getter, setter, constructor가 많아져서 복잡해지면
  보통은 lombok 라이브러리를 사용하는데, 나쁜거는 아니지만,

  기본적으로 한 모델클래스(데이터를 담고 있는 클래스)에 변수가 7개 이상이면
  그 변수의 디자인이 복잡하게 된것이다. 좀더 나은 방법으로 찾아보는 기준이 7개이다.
* */
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writter;
    private String password;
    private Long boardId;

    public PostDto() {
    }

    public PostDto(
            Long id,
            String title,
            String content,
            String writter,
            String password,
            Long boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writter = writter;
        this.password = password;
        this.boardId = boardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writter='" + writter + '\'' +
                ", password='" + password + '\'' +
                ", boardId=" + boardId +
                '}';
    }

    public PostDto passwordMasked(){
        return new PostDto(
                this.id,
                this.title,
                this.content,
                this.writter,
                "******",
                this.boardId

        );
    }



}

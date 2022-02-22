package dev.eldhdpswl.crudmission.post;

public class PostDto {
    private String title;
    private String content;
    private String writer;
    private String pwd;

    public PostDto() {
    }

    public PostDto(String title, String content, String writer, String pwd) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

package dev.eldhdpswl.mycommunityCase.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id //JPA에 Long id가 primary key 변수라는 것을 알려준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, PostEntity postEntity) {
        this.id = id;
        this.name = name;
        this.postEntity = postEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostEntity getPostEntity() {
        return postEntity;
    }

    public void setPostEntity(PostEntity postEntity) {
        this.postEntity = postEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postEntity=" + postEntity +
                '}';
    }
}

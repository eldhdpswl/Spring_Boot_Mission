package dev.eldhdpswl.mycommunityCase.repository;


import dev.eldhdpswl.mycommunityCase.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}

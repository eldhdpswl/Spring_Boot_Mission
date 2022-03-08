package dev.eldhdpswl.mycommunityCase.dao;

import dev.eldhdpswl.mycommunityCase.dto.PostDto;
import dev.eldhdpswl.mycommunityCase.dto.UserDto;
import dev.eldhdpswl.mycommunityCase.entity.PostEntity;
import dev.eldhdpswl.mycommunityCase.entity.UserEntity;
import dev.eldhdpswl.mycommunityCase.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final UserRepository userRepository;

    public UserDao(
            @Autowired UserRepository userRepository
            ) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(int id){
        Optional<UserEntity> userEntity = this.userRepository.findById((long) id);
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userEntity.get();
    }

    public Iterator<UserEntity> readPostAll(){
        return this.userRepository.findAll().iterator();
    }

    public void updatePost(int id, UserDto dto){
        Optional<UserEntity> targetEntity = this.userRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = targetEntity.get();

        userEntity.setName(
                dto.getName() == null ? userEntity.getName() : dto.getName());

        this.userRepository.save(userEntity);
    }

}

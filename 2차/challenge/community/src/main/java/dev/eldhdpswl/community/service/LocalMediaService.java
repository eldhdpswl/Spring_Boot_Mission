package dev.eldhdpswl.community.service;


import dev.eldhdpswl.community.model.MediaDescriptorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class LocalMediaService implements MediaService {
    private static final Logger logger = LoggerFactory.getLogger(LocalMediaService.class);
    private final String basePath = "./media";

    @Override
    public MediaDescriptorDto saveFile(MultipartFile file) {

        return this.saveToDir(file);
    }

    @Override
    public Collection<MediaDescriptorDto> saveFileBulk(MultipartFile[] files) {
        Collection<MediaDescriptorDto> resultList = new ArrayList<>();
        for(MultipartFile file: files){
            resultList.add(this.saveToDir(file));
        }
        return resultList;
    }

    @Override
    public byte[] getFileAsBytes(String resourcePath) {
        try{
            return Files.readAllBytes(Path.of(basePath, resourcePath));
        } catch (IOException e){
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    private MediaDescriptorDto saveToDir(MultipartFile file){
        MediaDescriptorDto descriptorDto = new MediaDescriptorDto();
        descriptorDto.setStatus(200);
        descriptorDto.setOriginalName(file.getOriginalFilename());

        try{
            // 만약에 두명이 사용자가 서로 같은 이름으로 파일을 올린다거나, 같은 부분들을 위해서 몇가지 전략을 세우고 파일을 저장한는 것을 추천한다.
            LocalDateTime now = LocalDateTime.now();
            String targetDir = Path.of(
                    basePath,
                    now.format(DateTimeFormatter.BASIC_ISO_DATE)).toString();
            String newFileName = now.format(DateTimeFormatter.ofPattern("HHmmss"))
                    + "_"
                    + file.getOriginalFilename();

            File dirNow = new File(targetDir);
            if(!dirNow.exists()) dirNow.mkdir();

            file.transferTo(Path.of(
                    targetDir,
                    newFileName
            ));
            descriptorDto.setResourcePath(Path.of(
                    targetDir,
                    newFileName).toString().substring(1) //좋은 방법은 아니지만, /media 나타낸다.
            );
            return descriptorDto;
        } catch (IOException e){
            logger.error(e.getMessage());
            descriptorDto.setMessage("failed");
            descriptorDto.setStatus(500);
            return descriptorDto;
        }
    }

}

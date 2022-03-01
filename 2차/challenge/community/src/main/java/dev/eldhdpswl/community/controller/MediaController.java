package dev.eldhdpswl.community.controller;

import dev.eldhdpswl.community.model.MediaDescriptorDto;
import dev.eldhdpswl.community.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.util.Collection;

@RestController
@RequestMapping("media")
public class MediaController {
    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);
    private final MediaService mediaService;

    /*
    @PostMapping("test")
    public void uploadMedia(
            @RequestParam("file") MultipartFile file
    ){
        String basePath = "./media";
        File directory = new File(basePath);

        if(!directory.exists()){
            directory.mkdir();
        }
        Path newFilePath = Path.of(basePath, file.getOriginalFilename());
        try {
            file.transferTo(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("upload")
    public ResponseEntity<MediaDescriptorDto> uploadMedia(
            @RequestParam("file") MultipartFile file){
        MediaDescriptorDto descriptorDto = this.mediaService.saveFile(file);
        return ResponseEntity
                .status(descriptorDto.getStatus())
                .body(descriptorDto);
    }

    @PostMapping("upload-bulk")
    public ResponseEntity<Collection<MediaDescriptorDto>> uploadMedaiBulk(
            @RequestParam("file") MultipartFile[] files
    ){
        return ResponseEntity
                .status(HttpStatus.MULTI_STATUS)
                .body(this.mediaService.saveFileBulk(files));

    }

    /*@GetMapping("**")
    public byte[] staticLikeEndpoint(
            HttpServletRequest request, HttpServletResponse response
    ){
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        return this.mediaService.getFileAsBytes(request.getRequestURI().split("media")[1]);

    }*/

    @GetMapping("**")
    public ResponseEntity<byte[]> staticLikeEndpoint(HttpServletRequest request){
        //HttpHeaders headers = new HttpHeaders();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(
                this.mediaService.getFileAsBytes(request.getRequestURI().split("media")[1]),
                headers,
                HttpStatus.OK
        );
    }




}

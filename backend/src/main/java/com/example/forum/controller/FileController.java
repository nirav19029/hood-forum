package com.example.forum.controller;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.forum.utils.FileUtil;

import java.io.File;
import java.io.IOException;
@RestController
@RequestMapping("forum/v1/images")
public class FileController {
    //root path for image files
    // private String FILE_PATH_ROOT = "images/";
    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) throws Exception{
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File(FileUtil.folderPath+filename));
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
package com.example.forum.service.post;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.forum.utils.FileUtil;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Override
    public void createDirIfNotExist() {
        // create directory to save the files
        File directory = new File(FileUtil.folderPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    @Override
    public String save(MultipartFile file) {
        byte[] bytes = new byte[0];
        createDirIfNotExist();
        try {
            bytes = file.getBytes();
            Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);
            String imageUrl = FileUtil.folderPath + file.getOriginalFilename();
            return imageUrl;
        } catch (IOException e) {
            throw new RuntimeException("Could not upload the image!");
        }
    }

}

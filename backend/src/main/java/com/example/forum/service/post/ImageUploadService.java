package com.example.forum.service.post;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    void createDirIfNotExist();

    String save(MultipartFile file);
}

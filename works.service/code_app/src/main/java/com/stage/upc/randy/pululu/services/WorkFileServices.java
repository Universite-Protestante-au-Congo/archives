package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.WorkFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface WorkFileServices {
    WorkFile store(MultipartFile file) throws IOException;

    WorkFile getFile(Long id);

    public Stream<WorkFile> getAllFiles();
}

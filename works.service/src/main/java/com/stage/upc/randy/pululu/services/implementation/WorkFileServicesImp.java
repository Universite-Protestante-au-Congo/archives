package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.WorkFile;
import com.stage.upc.randy.pululu.repository.WorkFileRepository;
import com.stage.upc.randy.pululu.services.WorkFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;
@Service
public class WorkFileServicesImp implements WorkFileServices {
    @Autowired
    WorkFileRepository workFileRepository;
    @Override
    public WorkFile store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        WorkFile workFile = new WorkFile();
        workFile.setName(fileName);
        workFile.setType(file.getContentType());
        workFile.setData(file.getBytes());
        return workFileRepository.save(workFile);
    }

    @Override
    public WorkFile getFile(Long id) {
        return workFileRepository.findById(id).get();
    }

    @Override
    public Stream<WorkFile> getAllFiles() {
        return workFileRepository.findAll().stream();
    }
}

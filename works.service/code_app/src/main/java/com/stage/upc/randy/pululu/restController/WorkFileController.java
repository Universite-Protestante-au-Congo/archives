package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.ResponseFile;
import com.stage.upc.randy.pululu.models.ResponseMessage;
import com.stage.upc.randy.pululu.models.WorkFile;
import com.stage.upc.randy.pululu.repository.WorkFileRepository;
import com.stage.upc.randy.pululu.services.WorkFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkFileController {
    @Autowired
    WorkFileServices workFileServices;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
        String message = "";
        try {
            workFileServices.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @RequestMapping(method =  RequestMethod.GET)
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = workFileServices.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        WorkFile workFile = workFileServices.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + workFile.getName() + "\"")
                .body(workFile.getData());
    }
}

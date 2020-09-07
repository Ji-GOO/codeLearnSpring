package com.jigoo.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Log4j
public class UploadController {

    @GetMapping("/uploadForm")
    public void uploadForm() {

        log.info("upload form");
    }

    @PostMapping("/uploadFormAction")
    public void uploadFormAction(MultipartFile[] uploadFile, Model model) {

        String uploadFolder = "/Users/jjs92/Documents/upload";

        for(MultipartFile multipartFile : uploadFile) {
            log.info("---------------------------------");
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            log.info("Upload File Size : " + multipartFile.getSize());

            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(saveFile);
            } catch(Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    @GetMapping("/uploadAjax")
    public void uploadAjax() {

        log.info("upload ajax");
    }

    @PostMapping("/uploadAjaxAction")
    public void uploadAjaxPost(MultipartFile[] uploadFile) {

        log.info("update ajax post...........");

        String uploadFolder = "/Users/jjs92/Documents/upload";

        for(MultipartFile multipartFile : uploadFile) {
            log.info("--------------------------");
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            log.info("Upload File Size : " + multipartFile.getSize());

            String uploadFileName = multipartFile.getOriginalFilename();

            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
            log.info("only file name : " + uploadFileName);

            File saveFile = new File(uploadFolder, uploadFileName);

            try {
                multipartFile.transferTo(saveFile);
            } catch(Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}

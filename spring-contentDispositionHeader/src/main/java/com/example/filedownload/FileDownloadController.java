package com.example.filedownload;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileDownloadController {

    @GetMapping("/download")
    public void downloadFile(@RequestParam("titulo") String titulo, HttpServletResponse response) throws IOException {
        
        String fileContent = "Hello, World! This is the content of the file.";
        
        String fileName = titulo + ".txt"; 

        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        response.getWriter().write(fileContent);
    }
}


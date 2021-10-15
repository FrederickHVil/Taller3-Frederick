package com.example.taller3frederick;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet(name = "MultipartServlet", value = "/multipartServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 *1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class MultipartServlet extends HttpServlet {
    private String UPLOAD_DIRECTORY = "uploads";

    public void init(){

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) uploadDir.mkdir();

        String fileName = "";
        try {
            for (Part part : request.getParts()){
                fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/successfully.html");
    }
    public void destroy(){

    }
}

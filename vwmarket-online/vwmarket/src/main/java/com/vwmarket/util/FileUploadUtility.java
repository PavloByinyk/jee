package com.vwmarket.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtility {

    private static final String ABS_PATH = "D:\\escape\\ee\\jee\\vwmarket-online\\vwmarket\\src\\main\\webapp\\assets\\images";
    private static String REAL_PATH = "";

    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
        //get real path

        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

        System.out.println("ABS_PATH " + ABS_PATH);
        System.out.println("REAL_PATH " + REAL_PATH);

        //check if directory exist
        if(!new File(ABS_PATH).exists()){
            //create directory
            new File(ABS_PATH).mkdirs();
        }

        if(!new File(REAL_PATH).exists()){
            //create directory
            new File(REAL_PATH).mkdirs();
        }


        try{
            // server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            // project directory upload
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        }catch (IOException ex){

        }

    }
}

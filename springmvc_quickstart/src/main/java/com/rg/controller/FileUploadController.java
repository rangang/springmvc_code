package com.rg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/29 9:57 上午
 * @Description:
 */
@Controller
public class FileUploadController {

    /**
     * 单文件上传
     * @param username
     * @param filePic
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {

        System.out.println(username);
        // 获取文件名
        String originalFilename = filePic.getOriginalFilename();
        // 保存文件
        filePic.transferTo(new File("/Users/zhsmac/Downloads/" + originalFilename));

        return "success";
    }

    /**
     * 多文件上传
     * @param username
     * @param filePic
     * @return
     * @throws IOException
     */
    @RequestMapping("/filesUpload")
    public String filesUpload(String username, MultipartFile[] filePic) throws IOException {

        System.out.println(username);

        for (MultipartFile multipartFile : filePic) {
            // 获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            // 保存文件
            multipartFile.transferTo(new File("/Users/zhsmac/Downloads/" + originalFilename));
        }

        return "success";

    }

}

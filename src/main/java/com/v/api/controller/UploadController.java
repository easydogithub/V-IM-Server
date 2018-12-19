package com.v.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("api")
public class UploadController {

    @Value("${web.upload-path}")
    private String uploadPath;

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String host = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
        String fileName = UUID.randomUUID() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        File targetFile = new File(uploadPath);
        JSONObject json = new JSONObject();
        if (!targetFile.exists()) {
            if(!targetFile.mkdirs()){
                json.put("msg", "error");
                return json.toJSONString();
            }
        }
        json.put("msg", "success");
        //json.put("filePath",request.getContextPath() + "/upload/" + fileName);
        File retfile = new File(uploadPath, fileName);
        //保存
        try {
            file.transferTo(retfile);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "error");
            return json.toJSONString();
        }
        json.put("filePath", host + "/" + fileName);
        return json.toJSONString();
    }
}

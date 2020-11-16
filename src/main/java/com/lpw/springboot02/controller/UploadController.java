package com.lpw.springboot02.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author lipw4
 */
@Controller
public class UploadController {

    /** 上传地址 */
    @Value("${file.upload.path}")
    private String filePath;

    Log log = LogFactory.get();

    @PostMapping("/upload")
    public String upload(MultipartFile attach, Model model){
        String path="E:/temp/";
        String finalName = "";

        if(!attach.isEmpty()){
            String oldName = attach.getOriginalFilename();
            //获取后缀
            String suffix = FilenameUtils.getExtension(oldName);
            //重命名
            String newFileName = UUID.randomUUID().toString().replace("-","")+"."+suffix;
            //解决一天内文件过多的问题
            String dataPath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //最终的文件名字
            finalName = dataPath+"/"+newFileName;
            File file = new File(path + finalName);
            //判断目录是否存在
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                //上传文件
                attach.transferTo(file);
                model.addAttribute("images",finalName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return finalName;
    }

    @RequestMapping("/download")
    public void downLoad(String fileName, HttpServletResponse response) throws Exception{
        File file = new File(filePath+File.separator+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
        //获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buf)) != -1){
            //写文件
            outputStream.write(buf,0,len);
        }
        outputStream.close();
        inputStream.close();
    }
}

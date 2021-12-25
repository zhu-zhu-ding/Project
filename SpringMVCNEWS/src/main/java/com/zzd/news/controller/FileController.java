package com.zzd.news.controller;

import com.alibaba.fastjson.JSON;
import com.zzd.news.msg.NewsResult;
import com.zzd.news.msg.PicSrcResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;
@Controller
public class FileController {

    @Value("${basePath}")
    private String basePath;
    @Value("${noPhoto}")
    private String nophoto;
    @Value("${baseUrl}")
    private String baseUrl;

    @RequestMapping("/picShow/{picName}")
    public void picShow(HttpServletResponse response, @PathVariable String picName) throws IOException {
        String imagePath = basePath+picName+".jpg";
        System.out.println(imagePath);
        response.reset();
        //判断文件是否存在
        File file = new File(imagePath);
        if (!file.exists()) {
            imagePath = basePath+nophoto;
        }
        // 得到输出流
        OutputStream output = response.getOutputStream();
        if (imagePath.toLowerCase().endsWith(".jpg"))// 使用编码处理文件流的情况：
        {
            response.setContentType("image/jpeg;charset=GB2312");// 设定输出的类型
            // 得到图片的真实路径
            // 得到图片的文件流
            InputStream imageIn = new FileInputStream(new File(imagePath));
            byte[] bytes = new byte[1024];
            while (imageIn.read(bytes)!=-1){
                output.write(bytes);
            }
        }
        output.close();
    }
    @RequestMapping("/updateFile")
    @ResponseBody
    public String updateCourse(HttpServletRequest request) throws IOException {

        String picFile = request.getParameter("pic_src");
        System.out.println(picFile);
        String fileName = UUID.randomUUID() + ".jpg";
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(picFile);
        String imagePath = basePath+fileName;
        File file = new File(imagePath);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        String [] picurl = new String[1];
        picurl[0]=baseUrl+fileName;

        return JSON.toJSONString(new PicSrcResult(200,"success",picurl));
    }

    // 多个图片/文件上传
    @RequestMapping(value = "/uploadMultipleFile")
    @ResponseBody
    public String uploadMultipleFile(@RequestParam MultipartFile[] picFiles) throws IOException, ServletException {

        System.out.println(picFiles.length);
        String path = basePath;
        String []picurls = new String [picFiles.length];
        if(picFiles.length>0){
            for(int i=0;i<picFiles.length;i++){
                if(picFiles[i]!=null){
                    String fileName = UUID.randomUUID() + ".jpg";
                    File file = new File(path + fileName);
                    picFiles[i].transferTo(file);
                    picurls[i]=baseUrl+fileName;
                }
            }
        }

        System.out.println(JSON.toJSONString(new PicSrcResult(200,"success",picurls)));
        return JSON.toJSONString(new PicSrcResult(200,"success",picurls));
    }
}

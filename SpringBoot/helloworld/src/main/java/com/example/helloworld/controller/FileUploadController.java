/**
 * 文件上传控制器
 * 用于处理客户端上传文件的请求
 */

package com.example.helloworld.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController  // 标记为 REST 控制器，所有方法返回值直接写入响应体
public class FileUploadController {
    /**
     * 处理 POST 请求，路径为 /upload
     * 客户端需以 multipart/form-data 格式提交，包含 nickname 和 photo 字段
     *
     * @param nickname 普通表单字段（字符串），可选
     * @param photo    上传的文件，必须使用 MultipartFile 接收
     * @param request  HttpServletRequest 对象，用于获取服务器上的真实路径
     * @return 返回上传成功的提示字符串
     * @throws IOException 当文件保存出错时抛出
     */

    @PostMapping("upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        // 1. 打印接收到的普通表单字段值（在控制台输出，方便调试）
        System.out.println(nickname);
        // 2. 打印上传文件的原始名称（例如 "avatar.jpg"）
        System.out.println(photo.getOriginalFilename());
        // 3.取文件类型
        System.out.println(photo.getContentType());
        // 4. 获取web服务器上用于存储上传文件的绝对路径(获取web服务器运行目录，这些文件最终要存储到web服务器上，这个web服务器是运行在Linux系统上的（云端的linux系统）
        // 也就是动态获取web服务器位置，现在web服务器是IDEA自带的Tomcat，以后在云端运行项目时，Tomcat自动运行在云端
        String path = request.getServletContext().getRealPath("/upload"); //request：前端发过来的请求对象，.getServletContext()方法获得这个请求的上下文对象
        System.out.println(path);
        // 5. 调用自定义方法保存“文件”和“web服务器运行地址”到指定路径
        saveFile(photo,path);
        return "上传成功";
    }

    /**
     * 将上传的 MultipartFile 保存到磁盘指定目录
     *
     * @param photo 上传的文件对象
     * @param path  目标保存目录（绝对路径）
     * @throws IOException 当文件写入失败时抛出
     */
    public void saveFile(MultipartFile photo,String path) throws IOException{
        // 判断存储目录是否存在，不存在则创建
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(path+"/"+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}

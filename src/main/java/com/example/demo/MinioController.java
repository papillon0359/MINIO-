package com.example.demo;

import com.example.demo.Result;
import com.example.demo.FileStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 操作minio的控制器类
 *
 * @author 白豆五
 * @version 2023/04/21
 * @since JDK8
 */
@RestController
@RequestMapping("/minio")
@Api(tags = "minio相关接口")
public class MinioController {

    @Autowired
    private FileStorageService fileStorageService;


    /**
     * 上传图片到minio
     *
     * @param file
     * @return
     */
    @PostMapping("upload")
    @ApiOperation(value = "图片上传接口")
    public Result uploadFile(MultipartFile file) throws IOException {
        try {
            // 获取文件名称
            String fileName = file.getOriginalFilename();
            /*解决多次上传同名文件覆盖问题*/
            // 在文件名称里面添加随机唯一的值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;
            // 获取文件输入流
            InputStream is = file.getInputStream();
            String imgUrl = fileStorageService.uploadImgFile("img", fileName, is);
            return Result.success(imgUrl, "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("上传失败");
        }
    }
}

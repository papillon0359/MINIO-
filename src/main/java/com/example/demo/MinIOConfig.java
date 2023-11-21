package com.example.demo;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO配置类
 *
 * @author 白豆五
 * @version 2023/04/21
 * @since JDK8
 */
@Configuration
public class MinIOConfig {

    @Autowired
    private MinIOConfigProperties minIOConfigProperties;

    // 注册MinIO实例
    @Bean
    public MinioClient buildMinioClient(){
        return MinioClient
                .builder()
                .credentials(minIOConfigProperties.getAccessKey(), minIOConfigProperties.getSecretKey())
                .endpoint(minIOConfigProperties.getEndpoint())
                .build();
    }
}

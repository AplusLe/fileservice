package com.aplus.fileservice;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@MapperScan("com.aplus.fileservice.file.mapper")
public class FileserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileserviceApplication.class, args);
    }

//    @Bean
//    public HttpMessageConverter fastJsonConverter(){
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        //fastJsonConfig.setDateFormat("yyyy-MM-dd");
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastMediaTypes.add(MediaType.MULTIPART_FORM_DATA);
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
//        return fastJsonHttpMessageConverter;
//    }
}

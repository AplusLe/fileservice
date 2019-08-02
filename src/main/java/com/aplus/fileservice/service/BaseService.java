package com.aplus.fileservice.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @packae com.aplus.fileservice.service
 * @auther Kevin
 * @date 03/07/2019 16:21
 */

public interface BaseService {
    public StorePath uploadFile(MultipartFile file) throws IOException;

    public String getURL();

    public String uploadFiles(MultipartFile[] files) throws IOException;

}

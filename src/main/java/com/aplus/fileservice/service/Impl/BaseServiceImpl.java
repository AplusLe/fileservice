package com.aplus.fileservice.service.Impl;

import com.aplus.fileservice.exception.BizException;
import com.aplus.fileservice.service.BaseService;
import com.aplus.fileservice.utils.EmptyUtils;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @packae com.aplus.fileservice.service.Impl
 * @auther Kevin
 * @date 03/07/2019 16:23
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private FdfsWebServer fdfsWebServer;

    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public StorePath uploadFile(MultipartFile file) throws IOException {
        if (EmptyUtils.isEmpty(file)) {
            throw new BizException();
        }
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath;
    }

    /**
     * 获取完整URL地址
     *
     * @return
     */
    @Override
    public String getURL() {
        return fdfsWebServer.getWebServerUrl();
    }

    /**
     * 批量上传
     *
     * @param files
     * @return
     * @throws IOException
     */
    @Override
    public String uploadFiles(MultipartFile[] files) throws IOException {
        return null;
    }
}

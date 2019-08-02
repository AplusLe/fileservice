package com.aplus.fileservice.file.service;

import com.aplus.fileservice.file.entity.Info;
import com.aplus.fileservice.model.FileFormRsp;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * 文件信息表 服务类
 * </p>
 *
 * @author kevin
 * @since 2019-07-05
 */

public interface IInfoService extends IService<Info> {
    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    FileFormRsp upload(MultipartFile file);

    /**
     * 文件下载
     */
    ResponseEntity<byte[]> downloadFile(String fileInfoId);
}

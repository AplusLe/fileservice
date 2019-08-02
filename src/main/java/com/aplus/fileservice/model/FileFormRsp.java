package com.aplus.fileservice.model;

import lombok.Data;

import java.util.Date;

/**
 * @packae com.aplus.fileservice.model
 * @auther Kevin
 * @date 11/07/2019 9:42
 */

/**
 * 文件上传返回
 */
@Data
public class FileFormRsp {
    /**
     * 文件Id
     */
    private String fileId;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 上传时间
     */
    private Date uploadDate;
}

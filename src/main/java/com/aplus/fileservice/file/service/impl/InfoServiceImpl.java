package com.aplus.fileservice.file.service.impl;

import com.aplus.fileservice.enums.BizExceptionEnum;
import com.aplus.fileservice.exception.BizException;
import com.aplus.fileservice.file.entity.Info;
import com.aplus.fileservice.file.mapper.InfoMapper;
import com.aplus.fileservice.file.service.IInfoService;
import com.aplus.fileservice.model.FileFormRsp;
import com.aplus.fileservice.service.BaseService;
import com.aplus.fileservice.utils.EmptyUtils;
import com.aplus.fileservice.utils.SnowflakeIdWorkerUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.google.common.hash.Hashing;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

/**
 * <p>
 * 文件信息表 服务实现类
 * </p>
 *
 * @author kevin
 * @since 2019-07-05
 */

@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    @Autowired
    BaseService baseService;

    @Autowired
    private SnowflakeIdWorkerUtil snowflakeIdWorkerUtil;

    @Override
    public FileFormRsp upload(MultipartFile file) {
        // baseService.uploadFile(file)
        StorePath storePath = null;
        try {
            storePath = baseService.uploadFile(file);
        } catch (IOException e) {
            throw new BizException(BizExceptionEnum.FILE_UPLOAD_ERROR);
        }
        //文件ID
        String fileId = buildFileId();
        //文件原始名称
        String originalFilename = file.getOriginalFilename();
        // 得到文件扩展名
        String ext = "";
        if (originalFilename.lastIndexOf(".") > 0) {
            ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        }
        // 计算文件MD5
        String md5;
        try {
            md5 = getMD5(file.getBytes());
        } catch (IOException e) {
            throw new BizException(BizExceptionEnum.FILE_UPLOAD_ERROR);
        }
        Info fileInfo = new Info();
        fileInfo.setId(fileId);
        fileInfo.setFileName(originalFilename);
        fileInfo.setFilePath(storePath.getPath());
        fileInfo.setFileSize(file.getSize());
        fileInfo.setFileVirtualPath(storePath.getFullPath());
        fileInfo.setFileState(0);
        fileInfo.setFileExt(ext);
        fileInfo.setFileMd5(md5);
        this.save(fileInfo);

        FileFormRsp fileFormRsp = new FileFormRsp();
        fileFormRsp.setFileId(fileId);
        fileFormRsp.setFileName(originalFilename);
        fileFormRsp.setFileSize(file.getSize());
        fileFormRsp.setUploadDate(new Date());
        //fileInfo
        return fileFormRsp;
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(String fileInfoId) {
        Info fileInfo = this.getById(fileInfoId);
        if (EmptyUtils.isEmpty(fileInfo)) {
            throw new BizException(BizExceptionEnum.PARAM_ERROR);
        }
        fileInfo.getFileVirtualPath();
        baseService.getURL();
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("content-type", "application/octet-stream");
            httpHeaders.add("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileInfo.getFileName(), "UTF-8"));
            URL url = new URL(baseService.getURL() + fileInfo.getFileVirtualPath());
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            if (bytes.length <= 0) {
                bytes = " ".getBytes();
            }
            return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

        } catch (Exception e) {
            throw new BizException(e);
        }
    }

    private String getMD5(byte[] bytes) {
        return Hashing.md5().hashBytes(bytes).toString();
    }

    private String buildFileId() {
        long number = snowflakeIdWorkerUtil.nextId();
        return Hashing.md5().hashBytes(String.valueOf(number).getBytes()).toString();
    }
}

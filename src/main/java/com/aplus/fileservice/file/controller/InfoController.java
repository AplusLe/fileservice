package com.aplus.fileservice.file.controller;


// import com.aplus.fileservice.annotation.ResponseResult;
import com.aplus.fileservice.file.service.IInfoService;
import com.aplus.fileservice.model.FileFormRsp;
import com.aplus.fileservice.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * 文件信息表 前端控制器
 * </p>
 *
 * @author kevin
 * @since 2019-07-05
 */
@Api(value = "文件服务", tags = "file-service")
@RestController
@RequestMapping("/file/info")
@Slf4j
public class InfoController {

    @Autowired
    IInfoService infoService;

    // @ResponseResult
    @ApiOperation("文件上传")
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> upload(@RequestParam("file") MultipartFile file) {
        log.info("come method");
        FileFormRsp result = infoService.upload(file);
        log.info("end");
        return new ResponseEntity(Response.success(result), HttpStatus.OK);
    }

//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String Upload(@RequestPart(value = "file") MultipartFile file) {
//        return file.getName();
//    }

    @ApiOperation("文件下载")
    @GetMapping("/download")
    public Response download(@RequestParam("fileId") String fileId) {
        infoService.downloadFile(fileId);
        return null;
    }
}

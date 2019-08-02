package com.aplus.fileservice.file.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author kevin
 * @since 2019-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("file_info")
@ApiModel(value = "Info对象", description = "文件信息表")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件ID")
    @TableField("id")
    private String id;

    @ApiModelProperty(value = "转码后的预览文件id")
    @TableField("previewFileId")
    private Integer previewFileId;

    @ApiModelProperty(value = "父id 首次上传父id为空，修改时上传修改前文件id")
    @TableField("parentFileId")
    private Integer parentFileId;

    @ApiModelProperty(value = "文件上传名")
    @TableField("fileName")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    @TableField("filePath")
    private String filePath;

    @ApiModelProperty(value = "文件 mime类型")
    @TableField("mimeType")
    private String mimeType;

    @ApiModelProperty(value = "文件大小")
    @TableField("fileSize")
    private Long fileSize;

    @ApiModelProperty(value = "文件MD5值")
    @TableField("fileMd5")
    private String fileMd5;

    @ApiModelProperty(value = "上传用户")
    @TableField("uploadUser")
    private String uploadUser;

    @ApiModelProperty(value = "上传用户Id")
    @TableField("uploadUserId")
    private Integer uploadUserId;

    @ApiModelProperty(value = "文件虚拟路径，对应 fastdfs 返回的文件全路径")
    @TableField("fileVirtualPath")
    private String fileVirtualPath;

    @ApiModelProperty(value = "文件下载路径")
    @TableField("downCount")
    private String downCount;

    @ApiModelProperty(value = "文件拓展名")
    @TableField("fileExt")
    private String fileExt;

    @ApiModelProperty(value = "文件状态 0：正常，1：删除")
    @TableField("fileState")
    private Integer fileState;

    @ApiModelProperty(value = "是否加密 （0：否，1：是）")
    @TableField("fileEncrypt")
    private Integer fileEncrypt;

    @ApiModelProperty(value = "文件上传时间")
    @TableField("uploadTime")
    private LocalDateTime uploadTime;

    @ApiModelProperty(value = "文件修改时间")
    @TableField("modifyTime")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "文件描述")
    @TableField("fileDesc")
    private String fileDesc;


}

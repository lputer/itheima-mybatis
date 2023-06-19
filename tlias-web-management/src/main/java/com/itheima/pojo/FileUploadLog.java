package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadLog {
    private Integer id; //ID
    private String filename; //原始文件名
    private Long size; //文件大小, 单位:字节
    private String extname; //文件拓展名, 如:.jpg
    private String url; //阿里云OSS文件url
    private LocalDateTime uploadTime; //文件上传时间
}
package com.itheima.mapper;

import com.itheima.pojo.FileUploadLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileUploadLogMapper {
    @Insert("insert into file_upload_log(filename, size, extname, url, upload_time) VALUES (#{filename},#{size},#{extname},#{url},#{uploadTime})")
    void insert(FileUploadLog fileUploadLog);
}

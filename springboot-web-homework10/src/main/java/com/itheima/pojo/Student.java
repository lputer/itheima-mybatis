package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Short gender;
    private String phone;
    private Short degree;
    private Short violationCount;
    private Short violationScore;
    private Integer classId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

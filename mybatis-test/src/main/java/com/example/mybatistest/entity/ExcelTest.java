package com.example.mybatistest.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class ExcelTest implements Serializable {
    private Long id;
    private String name;
    private String gender;
    private int score;
}

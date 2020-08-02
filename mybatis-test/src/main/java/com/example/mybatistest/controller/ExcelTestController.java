package com.example.mybatistest.controller;

import com.example.mybatistest.entity.ExcelTest;
import com.example.mybatistest.mapper.ExcelTestMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "【mybatis测试】")
public class ExcelTestController {

    @Resource
    private ExcelTestMapper excelTestMapper;

    //查询表里所有数据
    @ApiOperation("【注解版查询所有数据】")
    @GetMapping("/selectAll")
    public List<ExcelTest> selectAll(){
        List<ExcelTest> list=excelTestMapper.selectAll();
        return list;
    }

    @ApiOperation("【注解版根据id批量查询数据】")
    @GetMapping("/batchSelect")
    public List<ExcelTest> batchSelect(@RequestParam("ids")List<Long> ids){
        return excelTestMapper.batchSelect(ids);
    }

    @ApiOperation("【注解版插入单条数据】")
    @PostMapping("/insertOne")
    public int insertOne(@RequestBody ExcelTest excelTest){
        return excelTestMapper.insert(excelTest);
    }

    @ApiOperation("【注解版批量插入多条数据】")
    @PostMapping("/batchInsert")
    public Integer batchInsert(){

        List<ExcelTest> lists=new ArrayList<>();
        ExcelTest excelTest=new ExcelTest();
        excelTest.setGender("nan");
        excelTest.setName("张飞");
        excelTest.setScore(98);
        lists.add(excelTest);

        ExcelTest excelTest1=new ExcelTest();
        excelTest1.setScore(99);
        excelTest1.setName("项羽");
        excelTest1.setGender("男");
        lists.add(excelTest1);
        return excelTestMapper.batchInsert(lists);
    }

    @ApiOperation("【配置文件版查询全部数据】")
    @GetMapping("/selectAlls")
    public List<ExcelTest> selectAllData(){
        return excelTestMapper.selectAllData();
    }

    @ApiOperation("【配置文件版根据id查询单条数据】")
    @GetMapping("/selectOneById")
    public ExcelTest selectOneById(Long id){
        return excelTestMapper.selectOneById(id);
    }

    @ApiOperation("【配置文件版根据id集合批量查询数据】")
    @GetMapping("/batchGet")
    public List<ExcelTest> batchGet(@RequestParam("ids") List<Long> ids){
       return excelTestMapper.batchGet(ids);

    }

    @ApiOperation("【注解版批量插入多条数据】")
    @PostMapping("/batchInsertMany")
    public Integer batchInsertMany(){
        List<ExcelTest> list=new ArrayList<>();
        ExcelTest excelTest=new ExcelTest();
        excelTest.setGender("男");
        excelTest.setName("关羽");
        excelTest.setScore(99);
        list.add(excelTest);
        ExcelTest excelTest1=new ExcelTest();
        excelTest1.setScore(88);
        excelTest1.setName("马超");
        excelTest1.setGender("男");
        list.add(excelTest1);
        return excelTestMapper.batchInsertMany(list);



    }
    @ApiOperation("【分页想查询数据】")
    @GetMapping("/pageHelper")
    public PageInfo<ExcelTest> getdata(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize") int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<ExcelTest> list=excelTestMapper.selectAll();
        PageInfo<ExcelTest> info=new PageInfo<>(list, pageSize);
        return info;
    }
}

package com.example.mybatistest.mapper;

import com.example.mybatistest.entity.ExcelTest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExcelTestMapper {

    //查询表全部数据
    @Select("select * from excel_test")
    List<ExcelTest> selectAll();

    //按照id集合批量查询数据
    @Select("<script> select  * from excel_test WHERE id IN " +
            "<foreach  item='item' index='index' collection='ids' open='(' separator=',' close=')'> #{item}</foreach>  </script>")
    List<ExcelTest> batchSelect(@Param("ids") List<Long> ids);

    //注解版插入数据
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into excel_test(id,name,gender,score) values(#{id},#{name},#{gender},#{score})")
    Integer insert(ExcelTest excelTest);

    //注解版批量插入数据
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("<script>"  +
            "INSERT INTO excel_test(id,name,gender,score) VALUES" +
            "<foreach collection=\"list\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{item.id},#{item.name},#{item.gender},#{item.score})" +
            "</foreach>" +
            "</script>")
    Integer batchInsert(@Param("list") List<ExcelTest> list);

    //配置文件版查询所有数据
   List<ExcelTest>  selectAllData();

   //根据id查询单条数据
    ExcelTest selectOneById(Long id);

    //根据多个id批量查询数据
    List<ExcelTest> batchGet(@Param("ids") List<Long> ids);

    //批量插入多条数据
    Integer batchInsertMany(@Param("list") List<ExcelTest> list);

}

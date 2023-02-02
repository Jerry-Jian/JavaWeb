package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();
    void addBrand(Brand brand);
    void deleteByIds( @Param("ids") int[] ids);

    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    @Select("select count(*) from tb_brand ")
    int totalCount();
}

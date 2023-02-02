package service;

import pojo.Brand;
import pojo.pageBean;

import java.util.List;

public interface SelectAllImpl {
    List<Brand> selectAll();
    void addBrand(Brand brand);
    void deleteByIds(int[] ids);

    pageBean<Brand> selectByPage(int currentPage,int pageSize);
}

package service.Impl;
import com.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import pojo.pageBean;
import service.SelectAllImpl;
import util.SqlSessionFactoryutil;

import java.util.List;
import java.util.Optional;

public class selectAll implements SelectAllImpl {
    SqlSessionFactoryutil factory=new SqlSessionFactoryutil();
    @Override
    public List<Brand> selectAll() {
        SqlSessionFactory sqlSessionFactory = factory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        return brands;

    }

    @Override
    public void addBrand(Brand brand) {
        SqlSessionFactory sqlSessionFactory = factory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSessionFactory sqlSessionFactory = factory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public pageBean selectByPage(int currentPage, int pageSize) {
        SqlSessionFactory sqlSessionFactory = factory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> rows = mapper.selectByPage((currentPage-1)*pageSize, pageSize);
        int totalNumber = mapper.totalCount();
        pageBean<Brand> brands = new pageBean<Brand>();
        brands.setRows(rows);
        brands.setTotalNumber(totalNumber);
        sqlSession.close();
        return brands;
    }
}

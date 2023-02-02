package web;

import com.alibaba.fastjson.JSON;
import pojo.Brand;
import pojo.pageBean;
import service.Impl.selectAll;
import service.SelectAllImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends baseServlet{
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectAllImpl selectAllBrand=new selectAll();
        List<Brand> brands = selectAllBrand.selectAll();
        String jsonString = JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        SelectAllImpl selectAll=new selectAll();
        selectAll.addBrand(brand);
        resp.getWriter().write("success");

    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        int[] ints = JSON.parseObject(s, int[].class);
        selectAll selectAll = new selectAll();
        selectAll.deleteByIds(ints);
        resp.getWriter().write("success");

    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectAllImpl selectAllBrand = new selectAll();
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        pageBean pageBean1 = selectAllBrand.selectByPage(currentPage,pageSize);
        String jsonString = JSON.toJSONString(pageBean1);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}

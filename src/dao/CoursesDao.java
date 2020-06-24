package dao;

import bean.Courses;

import java.math.BigDecimal;
import java.util.List;

public interface CoursesDao {
    public boolean login(String name,String pwd);//登录
    public boolean register(Courses courses);//注册
    public List<Courses> getUserAll();//返回用户信息集合
    public boolean delete(String id) ;//根据id删除用户
    public boolean update(String id, String name, String category, String table_of_content, BigDecimal fees) ;
}

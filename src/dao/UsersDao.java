package dao;
import bean.Users;

import java.util.List;

public interface UsersDao {
    public boolean login(String name,String pwd);//登录
    public boolean register(Users user);//注册
    public List<Users> getUserAll();//返回用户信息集合
    public boolean delete(String id) ;//根据id删除用户
    public boolean update(String id, String pwd,String type, String name,String email,String phone) ;
}

package dao;

import bean.Payment;
import bean.Users;

import java.util.Date;
import java.util.List;

public interface PaymentDao {
    public boolean login(String name,String pwd);//登录
    public boolean register(Payment payment);//注册
    public List<Payment> getUserAll();//返回用户信息集合
    public boolean delete(String id) ;//根据id删除用户
    public boolean update(String pm_id, String user_id, String course_id, Date date, String amount, String type,String remarks) ;
}

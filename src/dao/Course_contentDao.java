package dao;

import bean.Course_content;
import bean.Users;

import java.util.List;

public interface Course_contentDao {
    public boolean login(String name,String pwd);//登录
    public boolean register(Course_content course_content);//注册
    public List<Course_content> getUserAll();//返回用户信息集合
    public boolean delete(String content_id) ;//根据id删除用户
    public boolean update(String content_id,String course_id,String content_topic_name,String detail_content,String video_link,String references) ;
}

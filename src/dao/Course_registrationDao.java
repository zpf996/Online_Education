package dao;

import bean.Course_content;
import bean.Course_registration;

import java.util.List;

public interface Course_registrationDao {
    public boolean login(String name,String pwd);
    public boolean register(Course_registration course_registration);
    public List<Course_registration> getUserAll();
    public boolean delete(String user_id,String course_id) ;
    public boolean update(String user_id,String course_id,String payment_id) ;

}

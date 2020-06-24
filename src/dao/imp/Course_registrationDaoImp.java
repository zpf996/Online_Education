package dao.imp;

import bean.Course_registration;
import bean.Courses;
import dao.Course_registrationDao;
import util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_registrationDaoImp implements Course_registrationDao {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }

    @Override
    public boolean register(Course_registration course_registration) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into course_registration(User_Id,Course_ID,Payment_ID) "+
                "values('"+course_registration.getUser_id()+"" +
                "','"+course_registration.getCourse_id()+"" +
                "','"+course_registration.getPayment_id()+"" +
                "')");
        if(i>0){
            flag = true;
        }
        else{
            System.out.println("insert error");
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public List<Course_registration> getUserAll() {
        List<Course_registration> list = new ArrayList<Course_registration>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course_registration");
            while (rs.next()) {
                Course_registration course_registration = new Course_registration();
                course_registration.setUser_id(rs.getString("User_Id"));
                course_registration.setCourse_id(rs.getString("Course_ID"));
                course_registration.setPayment_id(rs.getString("Payment_ID"));
                list.add(course_registration);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean delete(String user_id, String course_id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from courses where User_Id="+user_id+"and Course_ID="+course_id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String user_id, String course_id, String payment_id) {
        return false;
    }
}

package dao.imp;

import bean.Course_content;
import bean.Course_registration;
import dao.Course_contentDao;
import util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course_contentDaoImp implements Course_contentDao {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }

    @Override
    public boolean register(Course_content course_content) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into course_content (Content_Id,Course_Id,Content_Topic_Name,Detail_Content,Video_Link,References) "+
                "values('"+course_content.getContent_id()+"" +
                "','"+course_content.getCourse_id()+"" +
                "','"+course_content.getContent_topic_name()+"" +
                "','"+course_content.getDetail_content()+"" +
                "','"+course_content.getVideo_link()+""+
                "','"+course_content.getReferences()+""+
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
    public List<Course_content> getUserAll() {
        List<Course_content> list = new ArrayList<Course_content>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from course_content");
            while (rs.next()) {
                Course_content course_registration=new Course_content();
                course_registration.setContent_id(rs.getString("Content_Id"));
                course_registration.setCourse_id(rs.getString("Course_Id"));
                course_registration.setContent_topic_name(rs.getString("Content_Topic_Name"));
                course_registration.setDetail_content(rs.getString("Detail_Content"));
                course_registration.setVideo_link(rs.getString("Video_Link"));
                course_registration.setReferences(rs.getString("References"));
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
    public boolean delete(String content_id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from course_content where Content_Id="+content_id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String content_id, String course_id, String content_topic_name, String detail_content, String video_link, String references) {
        boolean flag=false;
        DBconn.init();
        String sql="update course_content set Course_Id='"+course_id
                +"',Content_Topic_Name='"+content_topic_name
                +"',Detail_Content='"+detail_content
                +"',Video_Link='"+video_link
                +"',References='"+references
                +"'where Content_Id="+content_id;
        int i=DBconn.addUpdDel(sql);
        if(i>0){
            flag=true;
        }
        DBconn.closeConn();
        return flag;
    }
}

package dao.imp;

import bean.Courses;
import dao.CoursesDao;
import util.DBconn;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesDaoImp implements CoursesDao {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }

    @Override
    public boolean register(Courses courses) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into courses (Course_ID,Course_Name,Category,Table_Of_Content,Course_Fees) "+
                "values('"+courses.getId()+"" +
                "','"+courses.getName()+"" +
                "','"+courses.getCategory()+"" +
                "','"+courses.getTable_of_content()+"" +
                "','"+courses.getFees()+""+
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
    public List<Courses> getUserAll() {
        List<Courses> list = new ArrayList<Courses>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from courses");
            while(rs.next()){
                Courses courses=new Courses();
                courses.setId(rs.getString("Course_ID"));
                courses.setName(rs.getString("Course_Name"));
                courses.setCategory(rs.getString("Category"));
                courses.setTable_of_content(rs.getString("Table_Of_Content"));
                courses.setFees(rs.getBigDecimal("Course_Fees"));
                list.add(courses);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from courses where Course_ID="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String name, String category, String table_of_content, BigDecimal fees) {
        boolean flag=false;
        DBconn.init();
        String sql="update courses set Course_Name='"+name
                +"',Category='"+category
                +"',Table_Of_Content='"+table_of_content
                +"',Course_Fees='"+fees
                +"'where Course_ID="+id;
        int i=DBconn.addUpdDel(sql);
        if(i>0){
            flag=true;
        }
        DBconn.closeConn();
        return flag;
    }
}

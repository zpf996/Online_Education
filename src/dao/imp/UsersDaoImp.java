package dao.imp;

import bean.Users;
import dao.UsersDao;
import util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImp implements UsersDao {
    @Override
    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from users where User_ID='"+name+"' and password='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("User_ID").equals(name) && rs.getString("password").equals(pwd)){
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean register(Users user) {
        boolean flag = false;
        DBconn.init();
        int i =DBconn.addUpdDel("insert into users (User_ID,Password,User_Type,Full_Name,User_Email,User_ContactNumber) "+
                "values('"+user.getId()+"" +
                "','"+user.getPassword()+"" +
                "','"+user.getUser_type()+"" +
                "','"+user.getName()+"" +
                "','"+user.getEmail()+"" +
                "','"+user.getPhone()+""+
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
    public List<Users> getUserAll() {
        List<Users> list = new ArrayList<Users>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from users");
            while(rs.next()){
                Users users=new Users();
                users.setId(rs.getString("User_ID"));
                users.setPassword(rs.getString("Password"));
                users.setUser_type(rs.getString("User_Type"));
                users.setName(rs.getString("Full_Name"));
                users.setEmail(rs.getString("User_Email"));
                users.setPhone(rs.getString("User_ContactNumber"));
                list.add(users);
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
        String sql = "delete  from users where User_ID="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public boolean update(String id, String pwd, String type, String name, String email, String phone) {
        return false;
    }
}

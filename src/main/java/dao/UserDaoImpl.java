package dao;

import entity.User;
import util.dbConnection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            dbConnection.getConnection();
            ResultSet rs = dbConnection.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'");
            while (rs.next()){
                if (rs.getString("name").equals(name)&&rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean register(User user) {
        boolean flag = false;
        dbConnection.getConnection();
        int i = dbConnection.addUpdDel("insert into user(name,pwd,sex,home,info) " +
                "values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')");
        if (i>0){
            flag = true;
        }
        dbConnection.close(dbConnection.getConnection());
        return flag;
    }

    public List<User> getUserAll() {
        try {
            List<User> list = new ArrayList<User>();
            dbConnection.getConnection();
            ResultSet rs = dbConnection.selectSql("select * from user");
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
            dbConnection.close(dbConnection.getConnection());
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        boolean flag = false;
        dbConnection.getConnection();
        String sql = "delete from user where id ="+id;
        int i = dbConnection.addUpdDel(sql);
        if (i>0){
            flag = true;
        }
        dbConnection.close(dbConnection.getConnection());
        return flag;
    }

    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        boolean flag = false;
        dbConnection.getConnection();
        String sql = "update user set name ='"+name
                +"' , pwd ='"+pwd
                +"' , sex ='"+sex
                +"' , home ='"+home
                +"' , info ='"+info+"' where id = "+id;
        int i = dbConnection.addUpdDel(sql);
        if (i > 0){
            flag = true;
        }
        dbConnection.close(dbConnection.getConnection());
        return flag;
    }
}

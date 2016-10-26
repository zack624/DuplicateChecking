/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.jdbc;

import home.nust.paging.model.DuplicateChecking;
import home.nust.paging.model.Page;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zack
 */
public class PageDaoImpl implements PageDao{
    
    private Connection getConnection(){
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zack?characterEncoding=utf8";
        String username = "root";
        String password = "1234";
        Connection connection = null;
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public int getCount() {
        Connection conn = getConnection();
        String sql = "select count(*) from duplicatechecking d";
        int count = 0;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //必须先调用next方法，移动ResultSet的指针
            if(rs.next())
                count = rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn != null)
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
        return count;
    }

    @Override
    public List<DuplicateChecking> getPage(int currentPage, int everyPageRecord) {
        Connection conn = getConnection();
        String sql = "select * from duplicatechecking d limit ?,?";
        List<DuplicateChecking> dcList = new ArrayList<DuplicateChecking>();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (currentPage - 1)*everyPageRecord);
            stmt.setInt(2,everyPageRecord);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                DuplicateChecking dc = recordToModel(rs);
                dcList.add(dc);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return dcList;
    }

    private DuplicateChecking recordToModel(ResultSet rs) throws SQLException {
        long id = rs.getLong(1);
        String name = rs.getString(2);
        String major = rs.getString(3);
        String className = rs.getString(4);
        String paperTitle = rs.getString(5);
        String teacher = rs.getString(6);
        String reasonOfChecking = rs.getString(7);
        java.sql.Date sqlDate = rs.getDate(8);
        Date date = null;
        if(null != sqlDate){
            date = new Date(sqlDate.getTime());
        }
        return new DuplicateChecking(id, name, major, className, paperTitle, teacher, reasonOfChecking, date);
    }
    
}

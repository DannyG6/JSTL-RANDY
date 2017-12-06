/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author DannyG
 */
public class UserDAO {

    public ArrayList getUserList() throws ClassNotFoundException, SQLException {
        ArrayList<User> userAL = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        int id;
        String name;
        String gender;
        
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM `user`");
        
         while(resultSet.next()){
            id = resultSet.getInt("id");
            name = resultSet.getString("name");            
            gender = resultSet.getString("gender");
            userAL.add(new User(id,name,gender));
        }
         return userAL;
    }
}

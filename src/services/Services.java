package services;


import model.Password;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class Services {

    static private Statement statement;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/ms";
            String user = "root";
            String pas = "B1lMFSIdCEu42qdk";

            Connection connection = DriverManager.getConnection(url, user, pas);
            statement = connection.createStatement();
           // statement.executeUpdate("USE ms;");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers(ArrayList<User> A) {

       try {
           ResultSet rs = statement.executeQuery("SELECT * FROM users");

           while (rs.next()) {
              User B = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
              A.add(B);
           }

       }
       catch (SQLException e) {
         e.printStackTrace();
       }


  }
    public void deleteUser(int Id) {
        try {
            statement.executeUpdate("DELETE FROM users WHERE id="+Integer.toString(Id)+";");

        }
         catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getUser(User A,int Id) {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            rs.next();
           while(rs.getInt(1)!=Id) {
                rs.next();
            }

            A.setUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }
         catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateUser(User B,int Id){

        try {

            String id="id="+"'"+Integer.toString(B.getId())+"'";
            String email="email="+"'"+B.getEmail()+"'";
            String firstName="firstName="+"'"+B.getFName()+"'";
            String lastName="lastName="+"'"+B.getLName()+"'";
            String post="post="+"'"+B.getPost()+"'";

            statement.executeUpdate("UPDATE users SET "+id+","+email+","+firstName+","+lastName+","+post +
                    "WHERE id="+Integer.toString(Id)+";" );



        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void addUser(User A){
        try {
            String email="'"+A.getEmail()+"'";
            String firstName="'"+A.getFName()+"'";
            String lastName="'"+A.getLName()+"'";
            String post="'"+A.getPost()+"'";

            String informUser=email +","+ firstName +","+ lastName +","+ post;

            statement.executeUpdate("INSERT INTO users (email,firstName,lastName,post)" +
                    "VALUES ("+ informUser + ");");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletePassword(int Id){
        try {
            statement.executeUpdate("DELETE FROM passwords WHERE id="+Integer.toString(Id)+";");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addPassword(Password A){
        try {
            String hash="'"+A.getHash()+"'";
            String salt="'"+A.getSalt()+"'";

            String informPassword=hash +","+ salt;

            statement.executeUpdate("INSERT INTO passwords (hash,salt)" +
                    "VALUES ("+ informPassword + ");");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePassword(Password B,int Id){
        try {
            String hash="hash="+"'"+B.getHash()+"'";
            String salt="salt="+"'"+B.getSalt()+"'";

            statement.executeUpdate("UPDATE passwords SET "+hash+","+salt+" " +
                                    "WHERE id="+Integer.toString(Id)+";" );

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getAllPasswords(ArrayList<Password> A){
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM passwords");

            while (rs.next()) {
                Password B = new Password(rs.getInt(2),rs.getInt(3));
                A.add(B);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

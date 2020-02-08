package busautomation;
/*
    Author ~ Erdem Çamlıoğlu - 2020
*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Users {
    private java.sql.Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private static String loginUser;
    public void setLoginUser(String a){
        loginUser= a;
        System.out.println("set"+a);
    }public static String getLoginUser(){
            System.out.println("get"+loginUser);
        return loginUser;
    }
    public Users(){
        String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db_name+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,database.user_id,database.password);
            System.out.println("Connected -> Users..");
        } catch (SQLException e) {
            System.out.println("Connection Failed -> Users......"+e);
        }
    }
    public boolean Login(String userName, String password){
        String query = "Select * From YOUR-DATASET where *-* = ? and *-*-* = ?"; //this information name for database (mysql Command)
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userName); //user id first question mark *-*
            preparedStatement.setString(2, password);//password second question mark *-*-*
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

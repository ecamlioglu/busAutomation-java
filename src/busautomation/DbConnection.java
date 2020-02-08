package busautomation;
/*
    Author ~ Erdem Çamlıoğlu - 2020
*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    java.sql.Connection con=null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    
    public DbConnection(){  //Database connection information.
        String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db_name+ "?useUnicode=true&characterEncoding=utf8";
        try {
            con=DriverManager.getConnection(url,database.user_id,database.password); 
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection fail.."+e);
        }
    }
    //public 
    public static void main(String[] args) throws SQLException{
        DbConnection conn=new DbConnection();
    }
}

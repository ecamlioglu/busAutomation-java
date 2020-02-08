package busautomation;
/*
    Author ~ Erdem Çamlıoğlu - 2020
*/
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bussInformation {
    private java.sql.Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public bussInformation() {
        String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db_name + "?useUnicode=true&characterEncoding=utf8";
        try {
            con = DriverManager.getConnection(url, database.user_id, database.password);
            System.out.println("Connected..");
        } catch (SQLException e) {
            System.out.println("Connection Failed..." + e);
        }
    }

    public ArrayList<Car> ShowCarInfo() {
        ArrayList<Car> output = new ArrayList<Car>();
        try {
            statement = con.createStatement();
            String query = "Select * From YOUR_DATABASE";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String plate = rs.getString("plate");
                Date entry_date = rs.getDate("entry_date");
                int inlet_weight = rs.getInt("inlet_weight");
                String driver = rs.getString("driver");
                Date exit_date = rs.getDate("exit_date");
                int output_weight = rs.getInt("output_weight");
                String registry_person = rs.getString("registry_person");
                Date registry_date = rs.getDate("registry_date");
                String car_brand = rs.getString("car_brand");
                String destination = rs.getString("destination");
                String exit_point = rs.getString("exit_point");
                output.add(new Car(id, plate, entry_date, inlet_weight, driver, exit_date, output_weight, registry_person, registry_date, car_brand, destination, exit_point));
            }
            return output;

        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void AddCarLogin(String plate, int inlet_weight, String driver, String registry_person, java.sql.Date entry_date, java.sql.Date registry_date, String car_brand, String destination, String exit_point) {
        String query = "Insert Into YOUR-Database (plate, entry_date, inlet_weight, driver, output_weight, registry_person, registry_date, car_brand, destination, exit_point) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, plate);
            preparedStatement.setDate(2, entry_date);
            preparedStatement.setInt(3, inlet_weight);
            preparedStatement.setString(4, driver);
            //preparedStatement.setDate(5, );
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, registry_person);
            preparedStatement.setDate(7, registry_date);
            preparedStatement.setString(8, car_brand);
            preparedStatement.setString(9, destination);
            preparedStatement.setString(10, exit_point);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception!" + ex);
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int NumberofVehicle() {
        int number = 0;
        try {
            statement = con.createStatement();
            String query = "Select * From busAutomation";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                number++;
            }
            return number;

        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void CarUpdate(int id, int output_weight, java.sql.Date exit_date) {
        String sorgu = "Update YOUR_DATABASE set output_weight = ? , exit_date = ? where id = ?";
        try {
            preparedStatement = con.prepareCall(sorgu);
            preparedStatement.setInt(1, output_weight);
            preparedStatement.setDate(2, exit_date);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

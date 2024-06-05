//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class db_connection {
    public static void main(String[] args) {

        Connection connect = null;
        Properties props = new Properties();
        props.setProperty("user", "postgres"); //postgresql dokumanlarından alındı.
        props.setProperty("password", "postgres");
        String url = "jdbc:postgresql://localhost/Employee?user=postgres&password=postgres";

        String sql = "SELECT * FROM employee";
        String update_sql = "UPDATE employee SET name='Nese ilhan' WHERE id=1";

        try{
            connect = DriverManager.getConnection(url, props);
            Statement st = connect.createStatement();
            Statement upst = connect.createStatement();
            upst.executeUpdate(update_sql); //güncellenen veriyi calistir
            ResultSet data = st.executeQuery(sql); //sorgudaki elemanlar resultSet'e atildi.

            while(data.next()){
                System.out.println("ID : "+data.getInt("id")
                        + " Name : "    +data.getString("name")
                        + " Position : "+data.getString("position")
                        + " Salary : "  +data.getInt("salary"));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }



    }
}

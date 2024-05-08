import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("localhost:1521/FreePDB1", "mcernaMP3", "hola")) {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;

 public class Main {
    public static void main(String[] args) {
        //String sql = "";
        String url = "jdbc:postgresql://localhost:5432/airline";
        String username = "postgres";
        String password = "non_dual";
        //Connection con = null;
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

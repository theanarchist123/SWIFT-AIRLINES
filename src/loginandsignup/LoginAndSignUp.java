
package loginandsignup;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAndSignUp {
    public Connection connect_database(){
    
        String url = "jdbc:postgresql://localhost:5432/airline";
        String username = "postgres";
        String password = "non_dual";
        Connection con = null;
    try{
        
        con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        System.out.println("Database connected successfully.");
    }catch(Exception e){
            System.out.println(e);
    }
        return con;


    //public static void main(String[] args) {
      //  NewLogin Login1 = new NewLogin();
        //Login1.setVisible(true);
        //Login1.pack();
       // Login1.setLocationRelativeTo(null);

    //}
        
    
    }

    
    public boolean login(Connection connection, String username, String password){
        ResultSet rs;
        Statement statement;
        
        try{
            String query = String.format("select password from customer where username = '%s'", username);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                return password.equals(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return false;
    }
    public ResultSet fetch_customer_information(Connection connection, String username){
        ResultSet rs = null;
        Statement statement;
        
        try{
            String query = String.format("select * from customer where username = '%s'", username);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);  
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return rs;
    }
    public void display_toast(javax.swing.JPanel toast) {
        toast.setVisible(true);
        
        int delay = 2500; 
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.setVisible(false);
            }
        }, delay);
    }


    public static void main(String[] args) {
      NewLogin Login1 = new NewLogin();
        Login1.setVisible(true);
        Login1.pack();
       Login1.setLocationRelativeTo(null);
    /*    String sql = "";
        String url = "jdbc:postgresql://localhost:5432/airline";
        String username = "postgres";
        String password = "non_dual";
        //Connection con = null;
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.executeQuery(sql);
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            System.out.println(e);
 }
*/

    }
}

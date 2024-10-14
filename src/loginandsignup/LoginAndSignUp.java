
package loginandsignup;
import java.sql.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import loginandsignup.BookTicket;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Random;


public class LoginAndSignUp {
    public Connection con = null;
    private static String dateOfTravel;
    private static String fromLocation;
    private static String toLocation;
    private static String currentUserId;
    private static String selectedFlightId;
    private static String selectedDepartTime;
    public Connection connect_database(){
        
        String url = "jdbc:mysql://localhost:3306/airline"; 
        String username = "root@localhost";
        String password = "goodwill@#4567";
        
    try{
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "goodwill@#4567");
        Statement st = con.createStatement();
        System.out.println("Database connected successfully.");
    }catch(SQLException e){
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

    

public boolean deptlogin(Connection connection, int username, String password){
        ResultSet rs;
        Statement statement;
        
        try{
            String query = String.format("select password from department where dep_id = '%d'", username);
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
    public boolean userlogin(Connection connection, String u1, String p1){
        ResultSet rs;
        Statement statement;
        
        try{
            String query = String.format("select password from userr where email_id = '%s'", u1);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                return p1.equals(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return false;
    }
    public boolean officelogin(Connection connection, String u1, String p1){
        ResultSet rs;
        Statement statement;
        
        try{
            String query = String.format("select password from office where username = '%s'", u1);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                return p1.equals(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return false;
    }
public void addUser(Connection connection, String u1, String p1, int dobInt, String g1) {
    PreparedStatement s = null;
    try {
        String query = "INSERT INTO userr(email_id, password, dob, gender) VALUES(?, ?, ?, ?)";
        s = connection.prepareStatement(query);
        
        s.setString(1, u1); // Email ID
        s.setString(2, p1); // Password
        s.setInt(3, dobInt); // Date of Birth as integer
        s.setString(4, g1); // Gender
        
        int rowsAffected = s.executeUpdate(); 
        if (rowsAffected > 0) {
            System.out.println("User added successfully.");
        }
    } catch (SQLException e) {
        System.out.println("Error adding user: " + e.getMessage());
    } finally {
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }
}
   private String generateTransactionId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    public String addTransaction(Connection connection, double amount,String emailId, String transactionTime) {
        PreparedStatement s = null;
        String transId = generateTransactionId();
        try {
            String query = "INSERT INTO Transaction_t(trans_id, amount, time_of_transaction, user_id) VALUES(?, ?, ?, ?)";
            s = connection.prepareStatement(query);
            
            s.setString(1, transId);
            s.setDouble(2, amount);
            s.setString(3, transactionTime);
            s.setString(4, emailId);
            
            
            int rowsAffected = s.executeUpdate(); 
            if (rowsAffected > 0) {
                System.out.println("Transaction added successfully. Transaction ID: " + transId);
                return transId;
            }
        } catch (SQLException e) {
            System.out.println("Error adding transaction: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement: " + e.getMessage());
                }
            }
        }
        return null; // Return null if transaction failed
    }
    public void printTableStructure(Connection connection) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, "Transaction_t", null);
            
            System.out.println("Transaction_t table structure:");
            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                String dataType = resultSet.getString("TYPE_NAME");
                int columnSize = resultSet.getInt("COLUMN_SIZE");
                
                System.out.println(columnName + " - " + dataType + "(" + columnSize + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error getting table structure: " + e.getMessage());
        }
    }

public ResultSet fetch_emp_info(Connection connection, String ssn) {
    ResultSet rs = null;
    PreparedStatement statement = null;

    try {
        String query = "SELECT name, age, salary, ssn FROM employee WHERE ssn = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, ssn); // Set the SSN parameter
        rs = statement.executeQuery();  
    } catch (SQLException e) {
        System.out.println("Error fetching employee info: " + e.getMessage());
    }

    return rs; // Return the ResultSet containing employee information
}
public ResultSet fetch_office_info(Connection connection, String dept_id) {
    ResultSet rs = null;
    PreparedStatement statement = null;

    try {
        String query = "SELECT Loc_id, Dept_id, Flight_id FROM dept_office WHERE Dept_id = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, dept_id); // Set the SSN parameter
        rs = statement.executeQuery();  
    } catch (SQLException e) {
        System.out.println("Error fetching employee info: " + e.getMessage());
    }

    return rs; // Return the ResultSet containing employee information
}
public ResultSet fetch_dept_info(Connection connection, String dep_id) {
    ResultSet rs = null;
    PreparedStatement statement = null;
    

    try {
        String query = "Select dname from department where dep_id = ?";
        
        statement = connection.prepareStatement(query);
        statement.setString(1, dep_id);
        rs = statement.executeQuery();
    } catch (SQLException e) {
        System.out.println("Error fetching department info: " + e.getMessage());
    }

    return rs;
}

    public void setTravelInfo(String date, String from, String to) {
        dateOfTravel = date;
        fromLocation = from;
        toLocation = to;
    }
    public static String getDateOfTravel() {
        return dateOfTravel;
    }

    public static String getFromLocation() {
        return fromLocation;
    }

    public static String getToLocation() {
        return toLocation;
    }
    public ResultSet fetchFlightInfo(Connection connection) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            String query = "SELECT Flight_id,sourcee,destination" +
                           " FROM flight " +
                           "WHERE sourcee = ? AND destination = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, fromLocation);
            pstmt.setString(2, toLocation);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error fetching flight info: " + e.getMessage());
        }
        return rs;
    }
    public void setCurrentUserId(String userId) {
        currentUserId = userId;
    }
    public void setSelectedFlightId(String flightId) {
        selectedFlightId = flightId;
    }
public void setSelectedDepartTime(String departTime) {
        selectedDepartTime = departTime;
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
    public TicketInfo fetch_ticket_info(Connection connection) throws SQLException {
        TicketInfo ticketInfo = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String query= "SELECT t.user_id, t.trans_id, f.Flight_id, f.sourcee, f.destination, f.time_of_travel " +
               "FROM Transaction_t t " +
               "CROSS JOIN Flight f;";

            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, selectedFlightId);
            pstmt.setString(2, currentUserId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                ticketInfo = new TicketInfo(
                    rs.getString("user_id"),
                    rs.getString("trans_id"),
                    selectedDepartTime,
                    rs.getString("Flight_id"),
                    rs.getString("source"),
                    rs.getString("destination"),
                    rs.getString("time_of_travel")
                );
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }

        return ticketInfo;
    }
    
    public class TicketInfo {
        public String name;
        public String transactionId;
        public String departAt;
        public String flightId;
        public String from;
        public String to;
        public String time;

        public TicketInfo(String name, String transactionId, String departAt, String flightId, String from, String to, String time) {
            this.name = name;
            this.transactionId = transactionId;
            this.departAt = departAt;
            this.flightId = flightId;
            this.from = from;
            this.to = to;
            this.time = time;
        }
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

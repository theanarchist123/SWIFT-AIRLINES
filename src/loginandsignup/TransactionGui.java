/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Random;


/**
 *
 * @author admin
 */
public class TransactionGui extends javax.swing.JFrame {
    LoginAndSignUp l1 = new LoginAndSignUp();
    Connection c1 = l1.connect_database();
    private static StoreData s1;
    
    
    /**
     * Creates new form TransactionGui
     */
    public TransactionGui() {
        
        
        JButton lb;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        updateTimeField();
        String v1 = generateTransactionId();
        
        
        
        Time.setEditable(false);
        loading.setVisible(false);
        choice1.add("<none>");
        choice1.add("UPI");
        choice1.add("Card Payment");
        choice1.add("Online banking");
        jButton1.addActionListener(a -> {
            loading.setVisible(true);
            s1 = new StoreData(UserInfo.getText(),v1);
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Do you want to process this transaction?",
                "Confirm Transaction",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String transactionId = processTransaction();
                    showSuccessDialog(transactionId);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Error processing transaction: " + e.getMessage(),
                        "Transaction Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Transaction failed!!");
                Amount.setText("Enter amount");
                UserInfo.setText("Enter Your First Name");
                loading.setVisible(false);
            }
        });
    }
    private void updateTimeField() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Time.setText(formattedDateTime);
        }


    private String processTransaction() throws SQLException {
        double amount = Double.parseDouble(Amount.getText());
        String paymentMethod = choice1.getSelectedItem();
        String emailId = UserInfo.getText();
        String transactionTime = Time.getText();
        
        return l1.addTransaction(c1, amount, emailId, transactionTime);
    }
    public static class StoreData{
        private String userId;
        private String TransID;
        public StoreData(String userId, String TransID){
           this.userId = userId;
           this.TransID = TransID;
        }
        public String getUser(){
            return userId;
        }
        public String getTrans(){
            return TransID;
        }
    }
    public static StoreData getStoreData(){
        return s1;
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
    private void showSuccessDialog(String transactionId) {
            LoginAndSignUp l1 = new LoginAndSignUp();
            Connection c1 = l1.connect_database();
        String emailId = UserInfo.getText();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel successLabel = new JLabel("Transaction Successful!");
        JLabel idLabel = new JLabel("Transaction ID: " + transactionId);
        JButton viewTicketButton = new JButton("View Ticket");
        
        panel.add(successLabel);
        panel.add(idLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        panel.add(viewTicketButton);
        
        viewTicketButton.addActionListener(e -> {
            
            // Add code here to open the ticket viewing page
                
                new PlaneTicket(l1, c1);
                dispose();
        });
        
        JOptionPane.showOptionDialog(
            this,
            panel,
            "Transaction Complete",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new Object[]{},
            null
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        choice1 = new java.awt.Choice();
        UserInfo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        loading = new javax.swing.JPanel();
        jlLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(123, 75, 148));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Transaction Details:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 340, 30));

        Time.setBackground(new java.awt.Color(123, 75, 148));
        Time.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("  Time");
        Time.setBorder(null);
        Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeActionPerformed(evt);
            }
        });
        jPanel1.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 200, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 230, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-time-30.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 30, 30));

        Amount.setBackground(new java.awt.Color(123, 75, 148));
        Amount.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Amount.setForeground(new java.awt.Color(255, 255, 255));
        Amount.setText("Enter Amount");
        Amount.setBorder(null);
        jPanel1.add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 230, 30));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 230, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-money-30.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-google-pay-35.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 320, 20));
        jPanel1.add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 160, 20));

        UserInfo.setBackground(new java.awt.Color(123, 75, 148));
        UserInfo.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        UserInfo.setForeground(new java.awt.Color(255, 255, 255));
        UserInfo.setText("Enter Your First Name");
        UserInfo.setBorder(null);
        UserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInfoActionPerformed(evt);
            }
        });
        jPanel1.add(UserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 230, 40));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 240, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-30.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 30, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(Choose payment option)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/banking-technology-concept-design-vector (1).jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));
        jLabel8.getAccessibleContext().setAccessibleName("JLabel8");
        jLabel8.getAccessibleContext().setAccessibleDescription("");

        jButton1.setBackground(new java.awt.Color(123, 75, 148));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TRANSACT");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 210, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 30, 40));

        loading.setBackground(new java.awt.Color(255, 51, 0));
        loading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loading.gif"))); // NOI18N
        jlLabel1.setText("jLabel1");
        loading.add(jlLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 40, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("  Processing Your Transaction...");
        loading.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, 40));

        jPanel1.add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 270, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 814, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInfoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
                dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JTextField Time;
    private javax.swing.JTextField UserInfo;
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jlLabel1;
    private javax.swing.JPanel loading;
    // End of variables declaration//GEN-END:variables
}

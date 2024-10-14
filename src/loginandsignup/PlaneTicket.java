/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;
import java.sql.*;

import loginandsignup.LoginAndSignUp.TicketInfo;
import loginandsignup.TransactionGui.StoreData;
import loginandsignup.Flightg1.FlightData;
import loginandsignup.BookTicket.BData;
import java.util.Random;
import java.security.SecureRandom;

import javax.swing.*;

/**
 *
 * @author admin
 */
public class PlaneTicket extends javax.swing.JFrame {
        LoginAndSignUp l1 = new LoginAndSignUp();
            Connection c1 =l1.connect_database();
            public ResultSet r2;
            public TicketInfo r3;
            private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SEAT_NUMBER_LENGTH = 5;
    private static SecureRandom random = new SecureRandom();
            

            

    /**
     * Creates new form PlaneTicket
     */
    public PlaneTicket(LoginAndSignUp l1, Connection c1) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
                    TransactionGui.StoreData s1 = TransactionGui.getStoreData();
            Flightg1.FlightData f1 = Flightg1.getFlightData();
            BookTicket.BData b1 = BookTicket.getBData();
        UseData(s1,f1,b1);
        
        
        
        
    }
    private void UseData(StoreData s1,FlightData f1,BData b1){
        try{
            jLabel4.setText(s1.getUser());
            jLabel10.setText(s1.getTrans()); 
            jLabel16.setText(f1.getID());
            jLabel32.setText(f1.getSource());
            jLabel31.setText(f1.getDest());
            jLabel15.setText(b1.getTime());
            jLabel8.setText(b1.getDate());
            jLabel7.setText(generateSeatNumber());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
public static String generateSeatNumber() {

        StringBuilder seatNumber = new StringBuilder(SEAT_NUMBER_LENGTH);
        
        for (int i = 0; i < SEAT_NUMBER_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            seatNumber.append(CHARACTERS.charAt(index));
        }
        
        return seatNumber.toString();
    }


    private void fetchAndDisplayTicketInfo() {
        try {
            TicketInfo ticketInfo = l1.fetch_ticket_info(c1);
            if (ticketInfo != null) {
                jLabel4.setText(ticketInfo.name);
                jLabel10.setText(ticketInfo.transactionId);
                jLabel15.setText(ticketInfo.departAt);
                jLabel16.setText(ticketInfo.flightId);
                jLabel32.setText(ticketInfo.from);
                jLabel31.setText(ticketInfo.to);
                String p1 = generateSeatNumber();
            } else {
                JOptionPane.showMessageDialog(this, "No ticket information found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching ticket information: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(235, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/—Pngtree—black and white icons of_7554658 (2) (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 320));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("UNKNOWN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 130, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 255));
        jLabel6.setText("DATE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 60, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("01234");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("YYYY-MM-DD");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 255));
        jLabel9.setText("FLIGHT ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 90, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("TID202401");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 153, 255));
        jLabel11.setText("TRANSACTION ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 160, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("23:00");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 60, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setText("DEPART AT:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 255));
        jLabel14.setText("ARRIVE AT:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 100, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("11:00");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 60, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("EXPRESSO21");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 40));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 570, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 153, 255));
        jLabel18.setText("SEAT:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 70, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("NAME:  ");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 90, 50));

        jLabel21.setBackground(new java.awt.Color(0, 0, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/main-logo-black-transparent(1).png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 190, 190));

        jLabel3.setBackground(new java.awt.Color(228, 223, 223));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BlankMap-World_gray.svg (2).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 571, 348));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Swift Airways");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Favicon-32x32.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-plane-68.png"))); // NOI18N
        jLabel17.setText("jLabel17");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 294, 79, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 25)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Boarding Pass");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel22)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 369, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 153, 255));
        jLabel31.setText("Mumbai Airport");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 109, 162, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 153, 255));
        jLabel32.setText("Delhi Airport");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 126, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/—Pngtree—black and white icons of_7554658 (3).png"))); // NOI18N
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 304, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 204));
        jLabel36.setText("TO:");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 70, -1, 38));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 204));
        jLabel37.setText("FROM:");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 227, -1, 38));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-plane-68(3).png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 153, 65, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PlaneTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaneTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaneTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaneTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    LoginAndSignUp l1 = new LoginAndSignUp();
                    Connection c1 = l1.connect_database();
                new PlaneTicket(l1,c1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}

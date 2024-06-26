/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package continental.hotel.booking.system;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnp
 */
public class invoiceWindow extends javax.swing.JFrame {

    /**
     * Creates new form invoiceWindow
     */
    private String[] rowData;
    
    
     
    public invoiceWindow(String[] rowData) {
        this.rowData = rowData;
        initComponents();
        this.setLocationRelativeTo(null);
        
        LocalDate checkInDate = LocalDate.parse(rowData[8]); //to change from string to date
        LocalDate checkOutDate = LocalDate.parse(rowData[9]);
        long daysOfStay = ChronoUnit.DAYS.between(checkInDate, checkOutDate); //to check the days between the dates
        double perNight = Double.parseDouble(rowData[7]); //to change string to double
        double total = perNight*daysOfStay;
        double roundedTotal = Double.parseDouble(String.format("%.2f", total)); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        nameTxt.setText(rowData[2]);
        emailTxt.setText(rowData[4]);
        dateTxt.setText(dateFormat.format(new Date())); //today's date
        
        String[] columnNames = {"Booking ID","Room ID","Room Type","Price/Night","Days of Stay","Total"};
        DefaultTableModel invoiceTableModel = new DefaultTableModel(columnNames,0);

        // Add the row data to the table model
        Object[] newRowData = {rowData[0],rowData[5], rowData[6], rowData[7],daysOfStay,roundedTotal};
        invoiceTableModel.addRow(newRowData);
        // Set the table model for the invoiceTable
        invoiceTable.setModel(invoiceTableModel);
        invoiceTable.setVisible(true);
        
        double subTotal = 0;
            for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                subTotal += (double) invoiceTableModel.getValueAt(i, 5);
            }
            
        subTotalTxt.setText(String.format("%.2f", subTotal));
        double serviceTax = 0.1*subTotal;
        taxTxt.setText(String.format("%.2f", serviceTax));
        double tourismTax = 10*daysOfStay;
        tourismTxt.setText(String.format("%.2f", tourismTax));
        double payment = subTotal + serviceTax + tourismTax;
        paymentTxt.setText(String.format("%.2f", payment));  
    }

    private invoiceWindow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        taxTxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tourismTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        paymentTxt = new javax.swing.JLabel();
        subTotalTxt = new javax.swing.JLabel();
        paymentButton = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JLabel();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taxTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        taxTxt.setText("jLabel1");

        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("INVOICE");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Continental Hotel");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel12.setText("SubTotal:");

        dateTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel13.setText("Service Tax (10%):");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel15.setText("Total (RM):");

        tourismTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tourismTxt.setText("jLabel2");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel17.setText("Tourism Tax (RM 10 per night):");

        jLabel5.setText("Bill to:");

        jLabel1.setText("Invoice Date:");

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Room ID", "Room Type", "Price/Night", "Nights", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        paymentTxt.setText("jLabel3");

        subTotalTxt.setText("jLabel3");

        paymentButton.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        paymentButton.setForeground(new java.awt.Color(119, 119, 119));
        paymentButton.setText("Payment Checkout");
        paymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentButtonActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Booking record will be deleted once payment is done.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(paymentButton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tourismTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(taxTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subTotalTxt))
                            .addComponent(paymentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(subTotalTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(taxTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tourismTxt, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(paymentTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paymentButton)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentButtonActionPerformed
        String amountPaid = JOptionPane.showInputDialog(null, "Enter the total amount paid by the customer:");
        if (amountPaid == null || amountPaid.isEmpty()) {
            return;
        }
        try {
            double amount = Double.parseDouble(amountPaid);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate the balance
        double totalAmount = Double.parseDouble(paymentTxt.getText());
        double amountPaidCus = Double.parseDouble(amountPaid);
        double balance = amountPaidCus - totalAmount;
        if (balance < 0) {
            // If the amount paid is less than the total amount, an error message displated
            JOptionPane.showMessageDialog(null, "Insufficient payment", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (balance == 0) {
            // If the amount paid is exactly the total amount, delete the booking record from the file
            
            Booking booking = new Booking();
            booking.deleteBooking(rowData[0]);

            JOptionPane.showMessageDialog(null, "Booking paid"
            + " in full and deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // close current frame
            adminPage AdminPage = new adminPage(); 
            AdminPage.setVisible(true);
            
        } else {
            // If the amount paid is more than the total amount, display the balance and a message requesting confirmation of the funds received
            String message = String.format("Payment received: RM %.2f\nTotal amount: RM %.2f\nBalance: RM %.2f", amountPaidCus, totalAmount, balance);
            message += "\n\nPlease confirm that the amount received is correct to checkout.";
            // Display the message in a dialog box
            int option = JOptionPane.showConfirmDialog(null, message, "Confirm Payment", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
               Booking booking = new Booking();
               booking.deleteBooking(rowData[0]);

                dispose(); // close current frame
                adminPage AdminPage = new adminPage(); 
                AdminPage.setVisible(true);
            }
        }
    }//GEN-LAST:event_paymentButtonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        bookingList checkout = new bookingList();
        checkout.show();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

   
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
            java.util.logging.Logger.getLogger(invoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new invoiceWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel dateTxt;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameTxt;
    private javax.swing.JButton paymentButton;
    private javax.swing.JLabel paymentTxt;
    private javax.swing.JLabel subTotalTxt;
    private javax.swing.JLabel taxTxt;
    private javax.swing.JLabel tourismTxt;
    // End of variables declaration//GEN-END:variables
}

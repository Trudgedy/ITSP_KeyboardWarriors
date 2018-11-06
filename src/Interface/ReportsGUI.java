/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//requires iText jar, available at http://www.java2s.com/Code/Jar/i/Downloaditextpdf543jar.htm

package Interface;

import Classes.Database;
import Classes.Order;
import Classes.Sale;
import Classes.UserAuthentication;
import com.itextpdf.text.BaseColor;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alastair
 */
public class ReportsGUI extends javax.swing.JFrame {
private UserAuthentication userAuth = new UserAuthentication();

    private ArrayList<Sale> income;
    private ArrayList<Order> expenses;
    private String totalLabelText;

    /**
     * Creates new form Reports
     */
    public ReportsGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        reportTypeLabel = new javax.swing.JLabel();
        reportTypeComboBox = new javax.swing.JComboBox<>();
        periodLabel = new javax.swing.JLabel();
        periodComboBox = new javax.swing.JComboBox<>();
        generateReportButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        saveAsPdfButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        expensesLabel = new javax.swing.JLabel();
        incomeLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        reportTypeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        reportTypeLabel.setText("Report Type:");

        reportTypeComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        reportTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turnover", "Profit" }));

        periodLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        periodLabel.setText("Period:");

        periodComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        periodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Last Month", "Last Year" }));

        generateReportButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        generateReportButton.setText("Generate Report");
        generateReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonActionPerformed(evt);
            }
        });

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        saveAsPdfButton.setText("Save as PDF");
        saveAsPdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsPdfButtonActionPerformed(evt);
            }
        });

        incomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(incomeTable);

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(expensesTable);

        expensesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        expensesLabel.setText("Expenses Table:");

        incomeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        incomeLabel.setText("Income Table:");

        totalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnHome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(incomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(reportTypeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(generateReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(saveAsPdfButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(expensesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportTypeLabel)
                    .addComponent(reportTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodLabel)
                    .addComponent(periodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expensesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(saveAsPdfButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        //Dispose Current Interface
        this.dispose();
        //Create new HomeGUI
        new HomeGUI(userAuth).setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonActionPerformed
        String reportType = reportTypeComboBox.getSelectedItem().toString();
        String period = periodComboBox.getSelectedItem().toString();
        income = null;
        expenses = null;
        int incomeAmount = 0;
        int expensesAmount = 0;
        int turnover = 0;

        Database generate = new Database();

        //Determine the period over which the report should span
        switch (period) {
            case "Last Year":
                income = generate.getSales(1);
                expenses = generate.getPaidOrders(1);
                break;
            case "Last Month":
                income = generate.getSales(2);
                expenses = generate.getPaidOrders(2);
                break;
            default:
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "No entries found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        //create a new model for the table and set headings
        DefaultTableModel incomeModel = new DefaultTableModel(0, 0);
        String incomeHeader[] = new String[]{"Date of Sale", "Price", "Quantity", "Item Name"};
        incomeModel.setColumnIdentifiers(incomeHeader);
        incomeTable.setModel(incomeModel);

        //iterate through the list of sales
        for (int i = 0; i < income.size(); i++) {
            incomeAmount = incomeAmount + income.get(i).getPrice();
            
            //add data to row
            Object[] incomeRow = {
                income.get(i).getDateofsale(),
                income.get(i).getPrice(), 
                income.get(i).getQuantity(), 
                income.get(i).getItemName()
            };

            //add row to table
            incomeModel.addRow(incomeRow);
        }
        
        //create a new model for the table and set headings
        DefaultTableModel expensesModel = new DefaultTableModel(0, 0);
        String expensesHeader[] = new String[]{"Order ID", "Business Name", "Amount", "Date"};
        expensesModel.setColumnIdentifiers(expensesHeader);
        expensesTable.setModel(expensesModel);
        
        //iterate through the list of orders
        for (int i = 0; i < expenses.size(); i++) {
            expensesAmount = expensesAmount + expenses.get(i).getAmount();
            
            //add data to row
            Object[] incomeRow = {
                expenses.get(i).getOrderid(),
                expenses.get(i).getBusinessname(), 
                expenses.get(i).getAmount(), 
                expenses.get(i).getDate()
            };

            //add row to table
            expensesModel.addRow(incomeRow);
        }
        
        turnover = incomeAmount - expensesAmount;
        
        if(reportType.equals("Profit")){
            totalLabelText = "Total profit is: R "+incomeAmount;
        }
        else {
            totalLabelText = "Total turnover is: R "+turnover;
        }
        
        totalLabel.setText(totalLabelText);
    }//GEN-LAST:event_generateReportButtonActionPerformed

    private void saveAsPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsPdfButtonActionPerformed
        // TODO add your handling code here:
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream("../Report.pdf"));
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReportsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        
        //create headings
        Paragraph incomeHeading = new Paragraph("Income", font);
        Paragraph expensesHeading = new Paragraph("Expenses", font);
        Paragraph label = new Paragraph(totalLabelText);
        Paragraph space = new Paragraph("");

        //create income table within pdf
        PdfPTable incomePdfTable = new PdfPTable(4);
        incomePdfTable.setSpacingBefore(25);
        incomePdfTable.setSpacingAfter(25);
        
        //declare column headings
        incomePdfTable.addCell("Date of Sale");
        incomePdfTable.addCell("Price");
        incomePdfTable.addCell("Quantity");
        incomePdfTable.addCell("Item Name");
        
        //iterate through the list of sales
        for (int i = 0; i < income.size(); i++) {
            //add cells to row
            incomePdfTable.addCell(income.get(i).getDateofsale());
            incomePdfTable.addCell("R " + income.get(i).getPrice());
            incomePdfTable.addCell(income.get(i).getQuantity() + "");
            incomePdfTable.addCell(income.get(i).getItemName());
        }
        
        //create expenses table within pdf
        PdfPTable expensesPdfTable = new PdfPTable(4);
        expensesPdfTable.setSpacingBefore(25);
        expensesPdfTable.setSpacingAfter(25);
        
        //declare column headings
        expensesPdfTable.addCell("Order ID");
        expensesPdfTable.addCell("Business Name");
        expensesPdfTable.addCell("Amount");
        expensesPdfTable.addCell("Date");
        
        //iterate through the list of orders
        for (int i = 0; i < expenses.size(); i++) {
            //add cells to row
            expensesPdfTable.addCell(expenses.get(i).getOrderid() + "");
            expensesPdfTable.addCell(expenses.get(i).getBusinessname());
            expensesPdfTable.addCell("R " + expenses.get(i).getAmount());
            expensesPdfTable.addCell(expenses.get(i).getDate());
        }
        
        //add headings, spaces and tables to pdf
        try {
            document.add(incomeHeading);
            document.add(space);
            document.add(incomePdfTable);
            document.add(expensesHeading);
            document.add(space);
            document.add(expensesPdfTable);
            document.add(label);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        document.close();
        
        JOptionPane.showMessageDialog(null, "Report Saved");
    }//GEN-LAST:event_saveAsPdfButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ReportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel expensesLabel;
    private javax.swing.JTable expensesTable;
    private javax.swing.JButton generateReportButton;
    private javax.swing.JLabel incomeLabel;
    private javax.swing.JTable incomeTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> periodComboBox;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox<String> reportTypeComboBox;
    private javax.swing.JLabel reportTypeLabel;
    private javax.swing.JButton saveAsPdfButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}

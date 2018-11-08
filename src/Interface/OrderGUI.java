/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Database;
import Classes.Item;
import Classes.Supplier;
import Classes.UserAuthentication;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trudgedy
 */
public class OrderGUI extends javax.swing.JFrame {

    private UserAuthentication userAuth = new UserAuthentication();

    /**
     * Creates new form OrderGUI
     */
    public OrderGUI() {
        initComponents();
        updateTable();

        txtfieldQuantity.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                sliderQuantity.setValue(Integer.parseInt(txtfieldQuantity.getText()));
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                sliderQuantity.setValue(Integer.parseInt(txtfieldQuantity.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTable = new javax.swing.JPanel();
        scrollPaneTable = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        panelHeader = new javax.swing.JPanel();
        lblCompanyName = new javax.swing.JLabel();
        panelFooter = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        panelOptions = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        txtfieldItem = new javax.swing.JTextField();
        lblSupplier = new javax.swing.JLabel();
        txtfieldSupplier = new javax.swing.JTextField();
        lblAvailable = new javax.swing.JLabel();
        checkboxAvailable = new javax.swing.JCheckBox();
        btnSearch = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        sliderQuantity = new javax.swing.JSlider();
        txtfieldQuantity = new javax.swing.JTextField();
        lblPriceInfo = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        btnPlaceOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Supplier", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        scrollPaneTable.setViewportView(OrderTable);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTable)
                .addContainerGap())
        );

        panelHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCompanyName.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        lblCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompanyName.setText("Bware");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCompanyName, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCompanyName)
                .addContainerGap())
        );

        panelFooter.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        lblItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblItem.setText("Item:");

        txtfieldItem.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblSupplier.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSupplier.setText("Supplier:");

        lblAvailable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAvailable.setText("Is Available:");

        checkboxAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxAvailableActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblQuantity.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblQuantity.setText("Quantity:");

        sliderQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderQuantityStateChanged(evt);
            }
        });

        txtfieldQuantity.setText("1");
        txtfieldQuantity.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtfieldQuantityCaretUpdate(evt);
            }
        });
        txtfieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldQuantityActionPerformed(evt);
            }
        });

        lblPriceInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceInfo.setText("Total Price:");

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalPrice.setText("R201");

        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOptionsLayout = new javax.swing.GroupLayout(panelOptions);
        panelOptions.setLayout(panelOptionsLayout);
        panelOptionsLayout.setHorizontalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfieldQuantity)
                    .addComponent(txtfieldSupplier, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfieldItem)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlaceOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelOptionsLayout.createSequentialGroup()
                        .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantity)
                            .addComponent(lblSupplier)
                            .addComponent(lblItem)
                            .addGroup(panelOptionsLayout.createSequentialGroup()
                                .addComponent(lblPriceInfo)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalPrice)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelOptionsLayout.createSequentialGroup()
                        .addComponent(lblAvailable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkboxAvailable)))
                .addContainerGap())
        );
        panelOptionsLayout.setVerticalGroup(
            panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOptionsLayout.createSequentialGroup()
                        .addComponent(lblAvailable)
                        .addGap(36, 36, 36)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOptionsLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblTotalPrice))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOptionsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPriceInfo)))
                        .addGap(18, 18, 18)
                        .addComponent(btnPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkboxAvailable))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxAvailableActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        //Dispose Current Interface
        this.dispose();
        //Create new HomeGUI
        new HomeGUI(userAuth).setVisible(true);


    }//GEN-LAST:event_btnHomeActionPerformed

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        //When the table is clicked 

        int selectedRow = OrderTable.getSelectedRow();

        String name = OrderTable.getModel().getValueAt(selectedRow, 0).toString();
        String supplier = OrderTable.getModel().getValueAt(selectedRow, 2).toString();
        boolean isChecked = (boolean) OrderTable.getModel().getValueAt(selectedRow, 3);

        txtfieldItem.setText(name);
        txtfieldSupplier.setText(supplier);
        checkboxAvailable.setSelected(isChecked);
    }//GEN-LAST:event_OrderTableMouseClicked

    private void sliderQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderQuantityStateChanged
        // TODO add your handling code here:
        txtfieldQuantity.setText(sliderQuantity.getValue() + "");
    }//GEN-LAST:event_sliderQuantityStateChanged


    private void txtfieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldQuantityActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtfieldQuantityActionPerformed

    private void txtfieldQuantityCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtfieldQuantityCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txtfieldQuantityCaretUpdate

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //search

        //checkboxAvailable
        if (txtfieldItem.getText().equals("") && txtfieldSupplier.getText().equals("")) {
            //Refresh Table
            updateTable();

        } else if (!txtfieldItem.getText().equals("") && txtfieldSupplier.getText().equals("")) {
            //Gets by name
            DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
            model.setRowCount(0);
            
            Database db = new Database();
ArrayList<Item> items = db.getItemsByName(txtfieldItem.getText());
            
            for (int i = 0; i < items.size(); i++) {

                boolean available = true;
                if (items.get(i).getQuantity() == 0) {
                    available = false;
                }

                Object[] row = {items.get(i).getItemName(), items.get(i).getPrice(), items.get(i).getSupplierName(), available};
                model.addRow(row);
            }
        } else if (txtfieldItem.getText().equals("") && !txtfieldSupplier.getText().equals("")) {
            //Get by supplier
DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
            model.setRowCount(0);
            
            Database db = new Database();
ArrayList<Item> items = db.getItemsBySupplier(txtfieldSupplier.getText());
            
            for (int i = 0; i < items.size(); i++) {

                boolean available = true;
                if (items.get(i).getQuantity() == 0) {
                    available = false;
                }

                Object[] row = {items.get(i).getItemName(), items.get(i).getPrice(), items.get(i).getSupplierName(), available};
                model.addRow(row);
            }
        } else {
            //Get by Supplier and Item 

DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
            model.setRowCount(0);
            
            Database db = new Database();
ArrayList<Item> items = db.getItemsByNameAndSupplier(txtfieldItem.getText(), txtfieldSupplier.getText());
            
            for (int i = 0; i < items.size(); i++) {

                boolean available = true;
                if (items.get(i).getQuantity() == 0) {
                    available = false;
                }

                Object[] row = {items.get(i).getItemName(), items.get(i).getPrice(), items.get(i).getSupplierName(), available};
                model.addRow(row);
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        Database db = new Database();
        int selectedIndex = OrderTable.getSelectedRow();

        String name = OrderTable.getValueAt(selectedIndex, 0).toString();
        int price = Integer.parseInt(OrderTable.getValueAt(selectedIndex, 1).toString());
        String isAvailable = OrderTable.getValueAt(selectedIndex, 3).toString();
        int quantity = Integer.parseInt(txtfieldQuantity.getText());
        int itemId = db.getItemsByName(name).get(0).getItemid();

        if (isAvailable.equalsIgnoreCase("true")) {
            db.insertOrder(itemId, price, quantity);
            db.updateOrderQuantity(itemId, quantity);
            JOptionPane.showMessageDialog(null, "Order Complete");
        } else {

            JOptionPane.showMessageDialog(null, "Item not available");
        }

    }//GEN-LAST:event_btnPlaceOrderActionPerformed

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
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox checkboxAvailable;
    private javax.swing.JLabel lblAvailable;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblPriceInfo;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JPanel panelTable;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JSlider sliderQuantity;
    private javax.swing.JTextField txtfieldItem;
    private javax.swing.JTextField txtfieldQuantity;
    private javax.swing.JTextField txtfieldSupplier;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        Database db = new Database();

        ArrayList<Item> itemArr = new ArrayList<>();
        itemArr = db.getItems();

        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < itemArr.size(); i++) {

            boolean available = true;
            if (itemArr.get(i).getQuantity() == 0) {
                available = false;
            }

            Object[] row = {itemArr.get(i).getItemName(), itemArr.get(i).getPrice(), itemArr.get(i).getSupplierName(), available};
            model.addRow(row);
        }
    }
}

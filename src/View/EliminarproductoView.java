/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import BO.ProductosBO;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author barah
 */
public class EliminarproductoView extends javax.swing.JFrame {

    ProductosBO productoBO = new ProductosBO();
    
    public EliminarproductoView() {
        initComponents();
    }

    /*METODO CUSTOM PARA LLAMAR DESDE BO Y LISTAR EN LA TABLA*/
    public void listarProductos() throws SQLException{
       productoBO.listarProductos(jTable1);
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
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonVerDatos = new javax.swing.JButton();
        regreso2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jLabelBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(67, 67, 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Goudy Stout", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(153, 104, 34));
        Titulo.setText("UNDER FIRE");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 6, 581, 47));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Inventario", "ID Proveedor", "ID Categoria", "Precio Venta", "Precio Compra"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 278, 603, 151));

        jButtonVerDatos.setText("Ver Datos");
        jButtonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDatosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVerDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 250, -1, -1));

        regreso2.setText("Regresar");
        regreso2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regreso2MouseClicked(evt);
            }
        });
        jPanel1.add(regreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 435, 95, 39));

        jLabel1.setText("Ingresa el ID del Producto a Eliminar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabelBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        jPanel1.add(jLabelBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 730, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regreso2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regreso2MouseClicked
        dispose();
    }//GEN-LAST:event_regreso2MouseClicked

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID para poder eliminar");
                
            }else{
                int idEliminar = Integer.parseInt(txtId.getText());
                String mensaje = productoBO.eliminarProductos(idEliminar);
                JOptionPane.showMessageDialog(null, mensaje);
                
                txtId.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDatosActionPerformed
         try {
            listarProductos();
        } catch (SQLException ex) {
            Logger.getLogger(EliminarproductoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVerDatosActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarproductoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonVerDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton regreso2;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}

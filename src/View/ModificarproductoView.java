/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import BO.ProductosBO;
import Entity.Productos;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarproductoView extends javax.swing.JFrame {

    ProductosBO productosBO = new ProductosBO(); 
    
    public ModificarproductoView() {
        initComponents();
    }

    /*METODO CUSTOM PARA LLAMAR DESDE BO Y LISTAR EN LA TABLA*/
    public void listarProductos() throws SQLException{
       productosBO.listarProductos(jTable2);
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonVerDatos = new javax.swing.JButton();
        regreso2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtInventario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtIdCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabelBG = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(67, 67, 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Goudy Stout", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(153, 104, 34));
        Titulo.setText("UNDER FIRE");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 17, 581, 47));

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Inventario", "ID Categoria", "ID Proveedor", "Precio Venta", "Precio Compra"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 667, 137));

        jButtonVerDatos.setText("Ver Datos");
        jButtonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDatosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVerDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 283, -1, -1));

        regreso2.setText("Regresar");
        regreso2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regreso2MouseClicked(evt);
            }
        });
        jPanel1.add(regreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 472, 95, 39));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el ID de producto a Modificar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        jPanel1.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 120, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Re ingrese el Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 120, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Re ingrese el Inventario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        jPanel1.add(txtInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re ingrese el Precio de Venta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        jPanel1.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 120, -1));

        txtIdCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 80, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Re ingrese el ID Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        jPanel1.add(txtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 80, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Re ingrese el ID Proveedor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Re ingrese el Precio de Compra");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));
        jPanel1.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 120, -1));

        jLabelBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        jPanel1.add(jLabelBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 740, 530));

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

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
         try {
    // Verifica si los campos necesarios están vacíos
    if (txtIdProducto.getText().isEmpty() || txtNombreProducto.getText().isEmpty() ||
        txtIdCategoria.getText().isEmpty() || txtIdProveedor.getText().isEmpty() ||
        txtInventario.getText().isEmpty() || txtPrecioVenta.getText().isEmpty() ||
        txtPrecioCompra.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para modificar el producto");
    } else {
        // Crea una nueva instancia de Productos y establece sus atributos
        Productos producto = new Productos();
        try {
            producto.setIdProducto(Integer.parseInt(txtIdProducto.getText())); 
            producto.setNombreProducto(txtNombreProducto.getText());
            producto.setIdCategoria(Integer.parseInt(txtIdCategoria.getText())); 
            producto.setIdProveedor(Integer.parseInt(txtIdProveedor.getText())); 
            producto.setInventario(Integer.parseInt(txtInventario.getText())); 
            producto.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText())); 
            producto.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText())); 

            // Llamada al mrtodo para modificar el producto y muestra el mensaje resultante
            String mensaje = productosBO.modificarProductos(producto);
            JOptionPane.showMessageDialog(null, mensaje);

            txtIdProducto.setText("");
            txtNombreProducto.setText("");
            txtIdCategoria.setText("");
            txtIdProveedor.setText("");
            txtInventario.setText("");
            txtPrecioVenta.setText(""); // Nuevo campo
            txtPrecioCompra.setText(""); // Nuevo campo
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Todos los IDs y cantidades deben ser números válidos");
            }
        }
    } catch (Exception e) {
        // Manejo genérico de excepciones
        JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el producto: " + e.getMessage());
        Logger.getLogger(ModificarproductoView.class.getName()).log(Level.SEVERE, null, e);
    }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void txtIdCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCategoriaActionPerformed

    private void jButtonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDatosActionPerformed
        try {
            listarProductos();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarproductoView.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ModificarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarproductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarproductoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVerDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton regreso2;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtInventario;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}

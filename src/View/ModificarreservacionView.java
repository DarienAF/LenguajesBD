/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import BO.ReservacionesBO;
import Entity.Reservaciones;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class ModificarreservacionView extends javax.swing.JFrame {

    ReservacionesBO reservaciones = new ReservacionesBO();
    
    public ModificarreservacionView() {
        initComponents();
    }
    
   public void Listarreservacion() throws SQLException {
        
        reservaciones.listarReservaciones(jTableReservaciones);
        
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
        jTableReservaciones = new javax.swing.JTable();
        jButtonVerDatos = new javax.swing.JButton();
        regreso2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtReservacionId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
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

        jTableReservaciones.setBackground(new java.awt.Color(255, 255, 255));
        jTableReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Reservacion", "ID Cliente", "Cantidad de Personas", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(jTableReservaciones);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 317, 667, 137));

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

        jLabel1.setText("Ingrese el ID de la Reservacion a modificar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        jPanel1.add(txtReservacionId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, -1));

        jLabel3.setText("Re ingrese el ID de Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        jPanel1.add(txtClienteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, -1));

        jLabel4.setText("Re ingrese la Cantidad ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, -1));

        jLabel5.setText("Re ingrese la Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 110, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

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

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
         try {
            // Verifica si los campos necesarios están vacíos
            if (txtReservacionId.getText().isEmpty() || txtClienteId.getText().isEmpty() ||
                txtCantidad.getText().isEmpty() || txtFecha.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para poder modificar la reservación");
            } else {
                // Crea una nueva instancia de Reservaciones y establece sus atributos
                Reservaciones reservacion = new Reservaciones();
                try {
                    reservacion.setId_reservaciones(Integer.parseInt(txtReservacionId.getText())); // Conversión de texto a entero
                    reservacion.setId_cliente(Integer.parseInt(txtClienteId.getText())); // Conversión de texto a entero
                    reservacion.setCantidad(Integer.parseInt(txtCantidad.getText())); // Conversión de texto a entero
                    
                    // Conversión de fecha del formato YYYY-MM-DD a LocalDate
                    LocalDate fecha = LocalDate.parse(txtFecha.getText());
                    reservacion.setDia(fecha);

                    // Llama al método para modificar la reservación y muestra el mensaje resultante
                    String mensaje = reservaciones.modificarReservaciones(reservacion);
                    JOptionPane.showMessageDialog(null, mensaje);

                    // Limpia los campos después de la modificación
                    txtReservacionId.setText("");
                    txtClienteId.setText("");
                    txtCantidad.setText("");
                    txtFecha.setText("");
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El ID de reservación, ID de cliente y cantidad deben ser números válidos");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Asegúrate de usar el formato YYYY-MM-DD.");
                }
            }
        } catch (Exception e) {
            // Manejo genérico de excepciones
            JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar la reservación: " + e.getMessage());
            Logger.getLogger(ModificarreservacionView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDatosActionPerformed
        try {
            Listarreservacion();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarreservacionView.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ModificarreservacionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarreservacionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarreservacionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarreservacionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ModificarreservacionView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVerDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableReservaciones;
    private javax.swing.JButton regreso2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtReservacionId;
    // End of variables declaration//GEN-END:variables
}

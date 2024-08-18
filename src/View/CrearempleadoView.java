/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

//IMPORTES IMPORTANTES
import BO.EmpleadosBO;
import Entity.Empleados;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.SQLException;

//INICIO DE JFRAME
public class CrearempleadoView extends javax.swing.JFrame {
    //INSTANCIA DE CLASE QUE MANEJE LA LOGICA DE NEGOCIO (BO)
    EmpleadosBO empleado = new EmpleadosBO();
    
    //INICIALIZA COMPONENTES DE VENTANA
    public CrearempleadoView() {
        initComponents();
    }
/*METODO CUSTOM PARA LLAMAR DESDE BO Y LISTAR EN LA TABLA*/
    public void listarEmpleados() throws SQLException{
       empleado.listarEmpleados(jTable1);
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
        regresoVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdOcupacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        labelBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(67, 67, 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Goudy Stout", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(153, 104, 34));
        Titulo.setText("UNDER FIRE");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 17, 581, 47));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Empleado", "ID Ocupacion", "Nombre", "Apellido", "Telefono", "Salario"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 328, 649, 121));

        jButtonVerDatos.setText("Ver Datos");
        jButtonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDatosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVerDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 294, -1, -1));

        regresoVolver.setText("Regresar");
        regresoVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresoVolverMouseClicked(evt);
            }
        });
        jPanel1.add(regresoVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 461, 95, 39));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Ocupacion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 70, -1, -1));

        txtIdOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdOcupacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdOcupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 92, 185, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 126, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 148, 185, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 182, -1, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 204, 185, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 70, -1, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 92, 185, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Salario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 126, -1, -1));
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 148, 185, -1));

        jButtonCrear.setText("Ingresar");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 244, -1, -1));

        labelBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        jPanel1.add(labelBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

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

    private void regresoVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresoVolverMouseClicked
        dispose();
    }//GEN-LAST:event_regresoVolverMouseClicked

    // Accion al hacer click al boton "INGRESAR"
    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
         try {
            // Verifica que todos los campos estén llenos
            if (txtNombre.getText().isEmpty() || labelBG.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() || txtSalario.getText().isEmpty() || 
                txtIdOcupacion.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenos");
                
            } else {
                // Crea una nueva instancia de Empleados y establece sus atributos
                Empleados emp = new Empleados();
                emp.setNombre_empleado(txtNombre.getText());
                emp.setApellido(labelBG.getText());
                emp.setTelefono(txtTelefono.getText());
                emp.setSalario(Integer.parseInt(txtSalario.getText()));
                emp.setId_ocupacion(Integer.parseInt(txtIdOcupacion.getText())); // Establece el id_ocupacion
                
                // Llama al método de lógica de negocio para crear el empleado
                String mensaje = empleado.crearEmpleado(emp);
                JOptionPane.showMessageDialog(null, mensaje);
                
                // Limpia los campos después de la creación
                txtNombre.setText("");
                labelBG.setText("");
                txtTelefono.setText("");
                txtSalario.setText("");
                txtIdOcupacion.setText(""); // Limpia el campo id_ocupacion
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El salario y el id de ocupación deben ser números válidos");
        } catch (Exception e) {
            Logger.getLogger(CrearempleadoView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtIdOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdOcupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdOcupacionActionPerformed

    // Accion al hacer click al boton " VER DATOS"
    private void jButtonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDatosActionPerformed
         try {
            listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(CrearempleadoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVerDatosActionPerformed

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
            java.util.logging.Logger.getLogger(CrearempleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearempleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearempleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearempleadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearempleadoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonVerDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelBG;
    private javax.swing.JButton regresoVolver;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtIdOcupacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

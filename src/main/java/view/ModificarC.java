/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuariosController;
import javax.swing.JOptionPane;
import model.vo.UsuarioVo;

/**
 *
 * @author NICOLAS
 */
public class ModificarC extends javax.swing.JFrame {

    private UsuariosController usercon;
    private UsuarioVo user;
    /**
     * Creates new form RegistrarC
     */
    public ModificarC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        etCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etEdad = new javax.swing.JTextField();
        etDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        etNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etGenero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(243, 243, 243));
        setMinimumSize(new java.awt.Dimension(779, 603));
        setUndecorated(true);

        body.setBackground(new java.awt.Color(243, 243, 243));
        body.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        btnGuardar.setBackground(new java.awt.Color(172, 78, 233));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Actualizar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Eliminar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        etCedula.setForeground(new java.awt.Color(102, 102, 102));
        etCedula.setText("Escriba el telefono del cliente aqui.");
        etCedula.setEnabled(false);
        etCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etCedulaMouseClicked(evt);
            }
        });
        etCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etCedulaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Genero");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cedula");

        etEdad.setForeground(new java.awt.Color(102, 102, 102));
        etEdad.setText("Escriba la edad del cliente aqui.");
        etEdad.setEnabled(false);
        etEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etEdadMouseClicked(evt);
            }
        });
        etEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etEdadActionPerformed(evt);
            }
        });

        etDireccion.setForeground(new java.awt.Color(102, 102, 102));
        etDireccion.setText("Escriba la direccion del cliente aqui.");
        etDireccion.setEnabled(false);
        etDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etDireccionMouseClicked(evt);
            }
        });
        etDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etDireccionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Direccion:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Edad");

        etNombre.setForeground(new java.awt.Color(102, 102, 102));
        etNombre.setText("Escriba el nombre del cliente aqui.");
        etNombre.setEnabled(false);
        etNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etNombreMouseClicked(evt);
            }
        });
        etNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etNombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombre:");

        etCorreo.setForeground(new java.awt.Color(102, 102, 102));
        etCorreo.setText("Escriba el correo del cliente aqui.");
        etCorreo.setEnabled(false);
        etCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etCorreoMouseClicked(evt);
            }
        });
        etCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etCorreoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Correo:");

        jLabel1.setBackground(new java.awt.Color(243, 243, 243));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalles Cliente");

        jLabel2.setText("Cerrar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        etGenero.setForeground(new java.awt.Color(102, 102, 102));
        etGenero.setText("Escriba el telefono del cliente aqui.");
        etGenero.setEnabled(false);
        etGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etGeneroMouseClicked(evt);
            }
        });
        etGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(20, 20, 20)
                        .addComponent(btnGuardar)
                        .addGap(280, 280, 280))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int click = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que desea eliminar este cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (click == JOptionPane.YES_OPTION) {
            if (usercon.eliminarUsuario(user.getId())) {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente!");
            } else {
                JOptionPane.showMessageDialog(this, "No se elimino el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void etCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etCedulaActionPerformed

    private void etNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etNombreActionPerformed

    private void etCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etCorreoActionPerformed

    private void etDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etDireccionActionPerformed

    private void etEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etEdadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!etNombre.getText().equals("") && !etCorreo.getText().equals("") && !etDireccion.getText().equals("") && !etEdad.getText().equals("") &&  !etGenero.getText().equals("")&& !etCedula.getText().equals("")) {
            UsuarioVo userData = new UsuarioVo(
                    1,
                    Integer.parseInt(etEdad.getText()),
                    Integer.parseInt(etGenero.getText()),
                    etNombre.getText(),
                    etCorreo.getText(),
                    etDireccion.getText(),
                    Integer.parseInt(etCedula.getText())
                   
            );
            userData.setId(user.getId());
            if (usercon.modificarUsuario(userData)) {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Usuario modificado correctamente!");
            } else {
                JOptionPane.showMessageDialog(this, "No se modifico el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
        }
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void etNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etNombreMouseClicked
        etNombre.setEnabled(true);
    }//GEN-LAST:event_etNombreMouseClicked

    private void etCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etCorreoMouseClicked
        etCorreo.setEnabled(true);
    }//GEN-LAST:event_etCorreoMouseClicked

    private void etDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etDireccionMouseClicked
        etDireccion.setEnabled(true);
    }//GEN-LAST:event_etDireccionMouseClicked

    private void etEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etEdadMouseClicked
        etEdad.setEnabled(true);
    }//GEN-LAST:event_etEdadMouseClicked

    private void etCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etCedulaMouseClicked
        etCedula.setEnabled(true);
    }//GEN-LAST:event_etCedulaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void etGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etGeneroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_etGeneroMouseClicked

    private void etGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etGeneroActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ModificarC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField etCedula;
    private javax.swing.JTextField etCorreo;
    private javax.swing.JTextField etDireccion;
    private javax.swing.JTextField etEdad;
    private javax.swing.JTextField etGenero;
    private javax.swing.JTextField etNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    /**
     * @param user the user to set
     */
    public void setUser(UsuarioVo user) {
        this.user = user;
        etCorreo.setText(user.getCorreo());
        etDireccion.setText(user.getDireccion());
        etEdad.setText(String.valueOf(user.getEdad()));
        etNombre.setText(user.getNombre());
        etCedula.setText(String.valueOf(user.getCedula()));
        etGenero.setText(String.valueOf(user.getGenero()));
       
    }

    /**
     * @param usercon the usercon to set
     */
    public void setUsercon(UsuariosController usercon) {
        this.usercon = usercon;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VentasController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.vo.VentaVo;

/**
 *
 * @author Shamir
 */
public class ModificarV extends javax.swing.JFrame {

    private ArrayList<String> data;
    private ArrayList<Integer> eliminar, devuelto;
    private VentasController ventasCon;
    private DefaultTableModel model;

    /**
     * Creates new form ModificarV
     */
    public ModificarV() {
        initComponents();
        model = (DefaultTableModel) tblFactura.getModel();
        eliminar = new ArrayList<>();
        devuelto = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        factura = new javax.swing.JPanel();
        lblNombreVen = new javax.swing.JLabel();
        lblNombreCli = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnConfirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(243, 243, 243));
        setModalExclusionType(null);

        factura.setBackground(new java.awt.Color(255, 255, 255));

        lblNombreVen.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNombreVen.setText("NOMBRE_VENDEDOR");

        lblNombreCli.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNombreCli.setText("NOMBRE_COMPRADOR");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("FACTURA DE COMPRA");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Vendedor");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Cliente");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("COMPRAS");

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Val. Unidad", "# Comprado", "Val. Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);
        tblFactura.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int pos = tblFactura.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) tblFactura.getModel();
                    int id_pro = Integer.parseInt(model.getValueAt(pos, 0).toString());
                    // Se guarda el id del producto que se elimino de la factura
                    eliminar.add(id_pro);
                    devuelto.remove(pos);
                    model.removeRow(pos);
                    calcularTotal();
                }
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotal.setText("0");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("VALOR TOTAL:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setText("* Haga doble click sobre el producto que desea retirar de la factura");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_sell_stock_32px.png"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel37.setText("* Click para editar cantidad");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("FECHA_VENTA");

        javax.swing.GroupLayout facturaLayout = new javax.swing.GroupLayout(factura);
        factura.setLayout(facturaLayout);
        facturaLayout.setHorizontalGroup(
            facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facturaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(lblNombreVen))
                .addGap(72, 72, 72)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreCli)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facturaLayout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facturaLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(facturaLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(28, 28, 28)
                        .addComponent(lblTotal))
                    .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(facturaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29))
                .addGap(123, 123, 123)
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        facturaLayout.setVerticalGroup(
            facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facturaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblFecha)
                .addGap(18, 18, 18)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreVen)
                    .addComponent(lblNombreCli))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(lblTotal)))
                .addGap(18, 18, 18))
        );

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConfirmar1.setText("CONFIRMAR CAMBIOS");
        btnConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        int colSeleccionada = tblFactura.getSelectedColumn();
        if (colSeleccionada == 3) {
            int filaSeleccionada = tblFactura.getSelectedRow();
            double cost_uni = Double.parseDouble(model.getValueAt(filaSeleccionada, 2).toString());
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad"));
            int cantidad_actual = Integer.parseInt(model.getValueAt(filaSeleccionada, 3).toString());
            
            if (cantidad > 0) {
                // verificamos que no se esten agregando nuevos productos
                if (cantidad <= cantidad_actual) {
                    double total = cost_uni * cantidad;
                    int nueva_cantidad = cantidad_actual - cantidad;
                    model.setValueAt(cantidad, filaSeleccionada, 3);
                    model.setValueAt(total, filaSeleccionada, 4);
                    if (nueva_cantidad != cantidad_actual) {
                        devuelto.set(filaSeleccionada, devuelto.get(filaSeleccionada) + nueva_cantidad);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Para agregar más productos realice una nueva venta", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                int click = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cambiar la cantidad a 0?. \n\n"
                        + "Se eliminara el producto de la factura", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (click == JOptionPane.YES_OPTION) {
                    int id_pro = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
                    // Se guarda el id del producto que se elimino de la factura
                    eliminar.add(id_pro);
                    devuelto.remove(filaSeleccionada);
                    model.removeRow(filaSeleccionada);
                }
            }
            calcularTotal();
        }
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int click = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que desea eliminar esta venta?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            int fila = Integer.parseInt(data.get(0));
            if (ventasCon.eliminarVenta(fila)) {
                JOptionPane.showMessageDialog(this, "Venta eliminada correctamente");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al tratar de eliminar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar1ActionPerformed
        int click = JOptionPane.showConfirmDialog(this, "Confirmar modificación", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            VentaVo venta = new VentaVo();
            cargarDatosVenta(venta);
            if (ventasCon.modificarVenta(venta, eliminar, devuelto)) {
                JOptionPane.showMessageDialog(this, "Venta modificada correctamente");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al tratar de modificar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

//        VentaVo prueba = new VentaVo();
//        cargarDatosVenta(prueba);
//        System.out.println("devueltos");
//        for (int i = 0; i < devuelto.size(); i++) {
//            System.out.println(devuelto.get(i));
//        }
//        System.out.println("productos");
//        for (int i = 0; i < prueba.getProductos().size(); i++) {
//            System.out.println(prueba.getProductos().get(i));
//        }
    }//GEN-LAST:event_btnConfirmar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarV().setVisible(true);
            }
        });
    }

    /**
     * Crea un objeto VentaVo para pasarselo al controlador y luego a VentaDao,
     * el cual usara los datos del objeto para modificar la venta.
     *
     * @param venta
     */
    private void cargarDatosVenta(VentaVo venta) {
        venta.setTotal(Double.parseDouble(lblTotal.getText()));
        venta.setId(Integer.parseInt(data.get(0)));
        venta.date_mod();
        for (int i = 0; i < model.getRowCount(); i++) {
            int producto = Integer.parseInt(model.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
            venta.addProducto(producto, cantidad);
        }
    }

    /**
     * Actualiza la gui con los datos de la venta
     *
     * @param data ArrayList que contiene el id de la venta, el nombre del
     * vendedor, comprador, la fecha y el valor total
     */
    public void setData(ArrayList<String> data) {
        this.data = data;
        System.out.println(data.size());
        System.out.println(data.get(5));
        System.out.println(data.get(1));

        //se cargan en la gui los datos
        lblNombreVen.setText(data.get(2));
        lblNombreCli.setText(data.get(3));
        lblTotal.setText(data.get(4));

        if (!data.get(5).equals("")) {
            // tiene fecha de modificación
            lblFecha.setText(data.get(5));
        } else {
            // no tiene fecha de modificacion
            lblFecha.setText(data.get(1));
        }

        cargarModelo();
    }

    /**
     * Obtiene los datos de la venta que se desea modificar y los carga en el
     * modelo de la JTable
     */
    private void cargarModelo() {
        int venta_id = Integer.parseInt(data.get(0));
        ventasCon.setTableFac(tblFactura);
        if (ventasCon.obtenerDatosTransaccion(venta_id)) {
            System.out.println("Datos de la venta cargados correctamente");
            for (int i = 0; i < model.getRowCount(); i++) {
                devuelto.add(0); // se agregan a un arraylist para llevar un control de las devoluciones
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cargar los datos de esta venta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calcula el valor total a pagar
     */
    private void calcularTotal() {
        double total = 0;
        // se obtienen lo productos de la factura y se calcula el precio total
        for (int i = 0; i < model.getRowCount(); i++) {
            total = total + Double.parseDouble(model.getValueAt(i, 4).toString());
            System.out.println("total " + total);
        }
        lblTotal.setText(String.valueOf(total));
    }

    public void setVentasCon(VentasController ventasCon) {
        this.ventasCon = ventasCon;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel factura;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombreCli;
    private javax.swing.JLabel lblNombreVen;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblFactura;
    // End of variables declaration//GEN-END:variables
}

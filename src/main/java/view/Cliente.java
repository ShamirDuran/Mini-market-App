/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuariosController;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

/**
 *
 * @author Shamir
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    UsuariosController userCon;
    UsuarioDao userDao;
    public Cliente() {
        initComponents();
        userDao = new UsuarioDao();
        userCon = new UsuariosController();
        userCon.setUsuarioDao(userDao);
        
        mostrarUsuarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        etBuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnBuscarPro = new javax.swing.JButton();
        sidepanel = new javax.swing.JPanel();
        plIinicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        plClientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        plProductos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        plVenta = new javax.swing.JPanel();
        lblVenta = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        plReportes = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();
        plInventario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblInventario = new javax.swing.JLabel();
        plTransacciones = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblTransacciones = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent.setBackground(new java.awt.Color(243, 243, 243));

        menu.setBackground(new java.awt.Color(243, 243, 243));

        etBuscar.setForeground(new java.awt.Color(102, 102, 102));
        etBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etBuscarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Click en el cliente para editar o eliminar");

        btnRegistrar.setBackground(new java.awt.Color(172, 78, 233));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("CLIENTES");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cedula", "Nombre", "Correo", "Direccion", "Edad", "Genero", "# Compras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.setGridColor(new java.awt.Color(255, 255, 255));
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsuario);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(2).setMinWidth(150);
            tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblUsuario.getColumnModel().getColumn(2).setMaxWidth(150);
            tblUsuario.getColumnModel().getColumn(3).setMinWidth(200);
        }

        btnBuscarPro.setBackground(new java.awt.Color(172, 78, 233));
        btnBuscarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_19px.png"))); // NOI18N
        btnBuscarPro.setBorderPainted(false);
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(etBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(menuLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarPro, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(etBuscar))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        sidepanel.setBackground(new java.awt.Color(172, 78, 233));
        sidepanel.setPreferredSize(new java.awt.Dimension(230, 785));

        plIinicio.setBackground(new java.awt.Color(172, 78, 233));
        plIinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plIinicioMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_home_19px.png"))); // NOI18N

        lblHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("Inicio");

        javax.swing.GroupLayout plIinicioLayout = new javax.swing.GroupLayout(plIinicio);
        plIinicio.setLayout(plIinicioLayout);
        plIinicioLayout.setHorizontalGroup(
            plIinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plIinicioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plIinicioLayout.setVerticalGroup(
            plIinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plClientes.setBackground(new java.awt.Color(172, 78, 233));
        plClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plClientesMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_people_19px_1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        lblClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setText("Clientes");

        javax.swing.GroupLayout plClientesLayout = new javax.swing.GroupLayout(plClientes);
        plClientes.setLayout(plClientesLayout);
        plClientesLayout.setHorizontalGroup(
            plClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plClientesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plClientesLayout.setVerticalGroup(
            plClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plProductos.setBackground(new java.awt.Color(172, 78, 233));
        plProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plProductosMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_product_19px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        lblProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos.setText("Productos");

        javax.swing.GroupLayout plProductosLayout = new javax.swing.GroupLayout(plProductos);
        plProductos.setLayout(plProductosLayout);
        plProductosLayout.setHorizontalGroup(
            plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plProductosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plProductosLayout.setVerticalGroup(
            plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plVenta.setBackground(new java.awt.Color(172, 78, 233));
        plVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plVentaMouseClicked(evt);
            }
        });

        lblVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVenta.setText("Venta");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_sell_19px.png"))); // NOI18N

        javax.swing.GroupLayout plVentaLayout = new javax.swing.GroupLayout(plVenta);
        plVenta.setLayout(plVentaLayout);
        plVentaLayout.setHorizontalGroup(
            plVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plVentaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plVentaLayout.setVerticalGroup(
            plVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plReportes.setBackground(new java.awt.Color(172, 78, 233));
        plReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plReportesMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_graph_15px.png"))); // NOI18N

        lblReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReportes.setForeground(new java.awt.Color(255, 255, 255));
        lblReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportes.setText("Reportes");

        javax.swing.GroupLayout plReportesLayout = new javax.swing.GroupLayout(plReportes);
        plReportes.setLayout(plReportesLayout);
        plReportesLayout.setHorizontalGroup(
            plReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plReportesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblReportes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plReportesLayout.setVerticalGroup(
            plReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plInventario.setBackground(new java.awt.Color(172, 78, 233));
        plInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plInventarioMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_product_documents_19px.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        lblInventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInventario.setForeground(new java.awt.Color(255, 255, 255));
        lblInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInventario.setText("Inventario");

        javax.swing.GroupLayout plInventarioLayout = new javax.swing.GroupLayout(plInventario);
        plInventario.setLayout(plInventarioLayout);
        plInventarioLayout.setHorizontalGroup(
            plInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plInventarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plInventarioLayout.setVerticalGroup(
            plInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        plTransacciones.setBackground(new java.awt.Color(172, 78, 233));
        plTransacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plTransaccionesMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_transaction_19px.png"))); // NOI18N

        lblTransacciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTransacciones.setForeground(new java.awt.Color(255, 255, 255));
        lblTransacciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTransacciones.setText("Transacciones");

        javax.swing.GroupLayout plTransaccionesLayout = new javax.swing.GroupLayout(plTransacciones);
        plTransacciones.setLayout(plTransaccionesLayout);
        plTransaccionesLayout.setHorizontalGroup(
            plTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plTransaccionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblTransacciones)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        plTransaccionesLayout.setVerticalGroup(
            plTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Mini Market");

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plIinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepanelLayout.setVerticalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel8)
                .addGap(124, 124, 124)
                .addComponent(plIinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout parentLayout = new javax.swing.GroupLayout(parent);
        parent.setLayout(parentLayout);
        parentLayout.setHorizontalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentLayout.createSequentialGroup()
                .addComponent(sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        parentLayout.setVerticalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            .addGroup(parentLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        RegistrarC Rcliente=new RegistrarC();
        Rcliente.setLocationRelativeTo(null);
        Rcliente.setUserCon(userCon);
        Rcliente.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        Rcliente.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void plIinicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plIinicioMouseClicked
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_plIinicioMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void plClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plClientesMouseClicked
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
        cliente.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_plClientesMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Producto producto = new Producto();
        producto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void plProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plProductosMouseClicked
        Producto producto = new Producto();
        producto.setVisible(true);
        producto.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_plProductosMouseClicked

    private void plVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plVentaMouseClicked
        RealizarVenta venta = new RealizarVenta();
        venta.setLocationRelativeTo(null);
        venta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_plVentaMouseClicked

    private void plReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plReportesMouseClicked
        ReporteDiario reportDay = new ReporteDiario();
        reportDay.setLocationRelativeTo(null);
        reportDay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_plReportesMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        InventarioV inventario = new InventarioV();
        inventario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void plInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plInventarioMouseClicked
        InventarioV inventario = new InventarioV();
        inventario.setVisible(true);
        inventario.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_plInventarioMouseClicked

    private void plTransaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plTransaccionesMouseClicked
        Transacciones transac = new Transacciones();
        transac.setLocationRelativeTo(null);
        transac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_plTransaccionesMouseClicked

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        int filaSeleccionada = tblUsuario.getSelectedRow();
        UsuarioVo user = new UsuarioVo(
                Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 0).toString()),
                1,
                Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 5).toString()),
                Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 6).toString()),
                tblUsuario.getValueAt(filaSeleccionada, 2).toString(),
                tblUsuario.getValueAt(filaSeleccionada, 3).toString(),
                tblUsuario.getValueAt(filaSeleccionada, 4).toString(),            
                Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 1).toString())
                
        );
        user.setTransacciones(Integer.parseInt(tblUsuario.getValueAt(filaSeleccionada, 7).toString()));
        

        ModificarC moduser = new ModificarC();
        moduser.setUser(user);
        moduser.setLocationRelativeTo(null);
        moduser.setUsercon(userCon);
        moduser.setVisible(true);
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        userCon.setTable(tblUsuario);
        String ref = etBuscar.getText();

        if (!userCon.buscarUsuario(ref)) {
            JOptionPane.showMessageDialog(null, "No se encontraron productos con el nombre " + ref + "!");

        }
    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void etBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etBuscarMouseClicked
        etBuscar.setText(null);
    }//GEN-LAST:event_etBuscarMouseClicked
                                   

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }
    
    public void mostrarUsuarios() {
        userCon.setTable(tblUsuario);
        if (userCon.obtenerListaUsuarios()) {
            System.out.println("Usuarios cargados correctamente");
        } else {
            System.out.println("Error al cargar los usuarios a la tabla");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField etBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTransacciones;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel plClientes;
    private javax.swing.JPanel plIinicio;
    private javax.swing.JPanel plInventario;
    private javax.swing.JPanel plProductos;
    private javax.swing.JPanel plReportes;
    private javax.swing.JPanel plTransacciones;
    private javax.swing.JPanel plVenta;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables
}

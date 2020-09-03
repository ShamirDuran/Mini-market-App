/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package view;
//
//import controller.ProductosController;
//import model.dao.ProductoDao;
//import controller.UsuariosController;
//import controller.VentasController;
//import java.util.ArrayList;
//import model.Singleton;
//import model.dao.UsuarioDao;
//import model.vo.ProductoVo;
//import model.dao.VentaDao;
//import model.vo.UsuarioVo;
//import model.vo.VentaVo;
//
///**
// *
// * @author NICOLAS
// */
//public class Prueba {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        /////////////////////////////// SINGLETON ///////////////////////////////
//
//        /**
//         * Se carga la información del trabajador que se logueo en el sistema
//         */
//        // Singleton.getInstance().setId(1);
//        // Singleton.getInstance().setRol(0);
//        // Singleton.getInstance().setEdad(20);
//        // Singleton.getInstance().setGenero(1);
//        // Singleton.getInstance().setNombre("Shamir Duran");
//        // Singleton.getInstance().setCorreo("shamirduran15@gmail.com");
//        // Singleton.getInstance().setDireccion("La universidad");
//        /////////////////////////////// PRODUCTOS /////////////////////////////////
//        ArrayList<ProductoVo> listFindP;
//
//        ProductoDao productoDao = new ProductoDao();
//
//        Factory factory = new Factory();
//        ProductosController proController = new ProductosController();
//        proController.setProductoDao(productoDao);
//
//        factory.cargarDatosProducto(productoDao); // se cargan los datos de ejemplo
//        proController.mostrarListaProductos(); // se imprimen los datos
//
//        proController.añadirProducto("ACEITE GOTA DE ORO", 14489, 3000, "ml", 64); // se añade un producto
//        proController.mostrarListaProductos();
//
//        System.out.println("\n\n********* PRUEBA ELIMINAR Productos *********");
//        proController.eliminarProducto(4);
//        proController.mostrarListaProductos();
//
//        System.out.println("\n\n********* PRUEBA BUSCAR Producto Y MODIFICAR *********");
//        listFindP = proController.buscarProducto("aceite");
//
//        System.out.println("\n/-- Modificando el producto encontrado: --/ \n" + listFindP.get(0));
//        listFindP.get(0).setPrecio(4000);
//        listFindP.get(0).setCantidad(20);
//        proController.modificarProducto(listFindP.get(0));
//        listFindP = proController.buscarProducto("aceite");
//
//        /////////////////////////////// USUARIOS /////////////////////////////////
//        System.out.println("\n\n********* PRUEBA AÑADIR USUARIOS *********");
//        ArrayList<UsuarioVo> listFind;
//
//        UsuarioDao usuarioDao = new UsuarioDao();
//
//        UsuariosController usuController = new UsuariosController();
//        usuController.setUsuarioDao(usuarioDao);
//
//        factory.cargarDatosUsuario(usuarioDao); // Se carga los datos de ejemplo en la db
//        usuController.mostrarListaUsuarios();
//
//        usuController.añadirUsuario(3, 28, 1, "Shamir Castro", "shamircastro15@gmail.com", "San Alonso");
//        usuController.mostrarListaUsuarios();
//
//        System.out.println("\n\n********* PRUEBA ELIMINAR USUARIOS *********");
//        usuController.eliminarUsuario(4);
//        usuController.mostrarListaUsuarios();
//
//        System.out.println("\n\n********* PRUEBA BUSCAR USUARIO Y MODIFICAR *********");
//        listFind = usuController.buscarUsuario("nicolas");
//        listFind = usuController.buscarUsuario("Shamir");
//
//        System.out.println("\n/-- Modificando el primer usuario encontrado: --/ \n" + listFind.get(0));
//        listFind.get(0).setEdad(55);
//        listFind.get(0).setCorreo("cambiodecorreo@gmail.com");
//        usuController.modificarUsuario(listFind.get(0));
//        usuController.buscarUsuario("Shamir Duran");
//
//        /////////////////////////////// VENTAS /////////////////////////////////
//        System.out.println("\n\n********* PRUEBA REGISTRAR VENTAS *********");
//        VentaDao ventaDao = new VentaDao();
//        ventaDao.setUsuarioDao(usuarioDao);
//        VentasController ventasController = new VentasController();
//        ventasController.setVentaDao(ventaDao);
//        factory.cargarDatosVenta(ventaDao, usuarioDao, productoDao);
//        ventasController.mostrarListaVentas();
//
//        System.out.println("\n\n********* PRUEBA ELIMINAR PRODUCTO EN EL MOMENTO DE ESTAR REALIZANDO VENTA  *********");
//
//        if (usuarioDao.buscarUsuarioId(7) != null) {
//            VentaVo venta3 = new VentaVo(usuarioDao.buscarUsuarioId(8));
//            venta3.añadirProducto(productoDao.obtenerProductoId(1), 4);
//            venta3.añadirProducto(productoDao.obtenerProductoId(2), 3);
//            venta3.añadirProducto(productoDao.obtenerProductoId(3), 2);
//            venta3.eliminarProducto(1);
//            venta3.añadirProducto(productoDao.obtenerProductoId(4), 1);
//            venta3.añadirProducto(productoDao.obtenerProductoId(10), 1);
//            venta3.mostrarVenta();
//            ventaDao.registrarVenta(venta3); // 3
//        }
//
//        System.out.println("\n\n********* PRUEBA ELIMINAR VENTA *********");
//        ventasController.eliminarVenta(4);
//        ventasController.mostrarListaVentas();
//
//        // Esta situación se presentaria cuando un cliente desea devolver un producto.
//        // Para solicitar el reembolso debe de traer la factura para ver el id de esta.
//        System.out.println("\n\n********* PRUEBA BUSQUEDA Y MODIFICACIÓN DE VENTA *********");
//        ArrayList<VentaVo> venta = ventaDao.buscarVenta("2");
//        venta.get(0).mostrarVenta();
//
//        venta.get(0).eliminarProducto(5);
//        ventaDao.modificarVenta(venta.get(0));
//
//        venta = ventaDao.buscarVenta("2");
//        venta.get(0).mostrarVenta();
//
//        proController.obtenerListaProductos();
//        usuController.obtenerListaUsuarios();
//
//        proController.mostrarListaProductos();
//        System.out.println("total ventas del cajero " + Singleton.getInstance().getNombre() + " = "
//                + Singleton.getInstance().getTotal_ventas());
//        usuController.mostrarListaUsuarios();
//
//        /////////////////////////////// INVENTARIO /////////////////////////////////
//        System.out.println("\n\n********* PRUEBA INVENTARIO *********");
//        Inventario inventario = new Inventario();
//        inventario.setProController(proController);
//
//        inventario.mostrarInventario();
//
//        /////////////////////////////// REPORTES /////////////////////////////////
//        System.out.println("\n\n********* PRUEBA REPORTES *********");
//        Reporte reporte = new Reporte();
//        reporte.setProController(proController);
//        reporte.setUsuController(usuController);
//        reporte.setVentaController(ventasController);
//
//        reporte.hacerReporteCompleto();
//
//    }
//}

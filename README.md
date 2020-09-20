# Mini-market-App

Mini Market es una aplicación desarrollada con el objetivó
de servir como apoyo a los negocios en crecimiento para que
puedan dar el salto a la transformación digital fácilmente.

Con Mini market podrán llevar el control de su inventario, clientes,
ventas ayudando así a que se tomen mejores decisiones empresariales
y el negocio crezca.

**Desarrollada en 2020 utilizando Apache NetBeans IDE 12.0**

## Librerias usadas en el proyecto
* **JasperReport** para generar la vista de factura.
* **JFreeChart:** para generar las gráficas de los reportes.

Y algunas otras librerias que pueden detallar en el archivo pom.xml del proyecto.

## Como iniciar el proyecto

Para que el proyecto funcione se debe crear una base de datos relacional ,ya sea utilizando XAMPP o algun otro método. 
En nuestro caso dejamos el usuario por defecto *root* y la contraseña en blanco, y llamamos la db como *minimarket*.

<br>

En caso de que se desee cambiar el nombre de la db o las credenciales, se debe de modificar las variables en la clase *Conexion*

![image](https://user-images.githubusercontent.com/40668021/93540238-b5a14d80-f918-11ea-94eb-54cb26d476ab.png)

En la siguiente dirección *src\main\java\model* del proyecto se encuentran 3 archivos SQL:
* db.sql
* inserts.sql
* procedimientos_almacenados.sql

los cuales contienen el código para crear la db, crear los procedimiento almacenados e insertar datos de prueba. Se pueden ejecutar
utilizando MySQLWorkbench, insertando el código en phpmyadmin o de alguna otra forma que se prefiera.

Para que el generar la factura funcione se deben instalar los siguientes plugins en NetBeans:
* iReport-5.5.0.nbm
* jasperreports-components-plugin-5.5.0.nbm
* jasperserver-plugin-5.5.0.nbm
* org-jdesktop-layout-RELEASE65.nbm

**Se pueden descargar desde:** https://mega.nz/file/ZQZ3BQjS#sA7DhMw1Rr1tytBnPd-nYFrg_vgAZ0dZpx1NbzmDexE

Cuando se instalen, en la barra superior de NetBeans aparecera el siguiente icono
![image](https://user-images.githubusercontent.com/40668021/93542006-9527c200-f91d-11ea-96bb-7978c248f7ed.png)

Se debe presionar, y en el cuadro que aparece dar click en New y seleccionar la siguiente opción
![image](https://user-images.githubusercontent.com/40668021/93542187-f8b1ef80-f91d-11ea-91aa-d29835e6e823.png)

Y en la siguiente ventana llenar los campos con las credenciales de la base de datos
![image](https://user-images.githubusercontent.com/40668021/93542393-85f54400-f91e-11ea-9595-392b28d6602a.png)

* En JDBC Driver se selecciona *MySQL (com.mysql.jdbc.Driver)*

* En el campo JDBC URL se escribe *jdbc:mysql://localhost:3306/minimarket?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC* (si se cambio el nombre de la db
se debe cambiar despues del *localhost* el *minimarket* por el nombre usado en la db.

* Se da click en *Test* para comprobar que la conexión funcione y luego en *Save*.
<br><br>
**Con esto ya tendriamos todo el proyecto funcionando junto a la opción de generar factura, ya sea para guardarla o imprimirla.**

# Vistas

## Inicio
![image](https://user-images.githubusercontent.com/40668021/93691663-00080300-faae-11ea-95cd-06e6994d1b8f.png)

## Clientes
En la vista de Clientes se muestra la información de todos los usuarios registrados en la base de datos. 

![image](https://user-images.githubusercontent.com/40668021/93691701-dbf8f180-faae-11ea-9da0-a78530475e1e.png)

Se puede realizar búsqueda por nombre, registrar, modificar o eliminar usuarios.

![image](https://user-images.githubusercontent.com/40668021/93691714-09459f80-faaf-11ea-8aa5-97606dc65e1b.png)

## Productos
Se muestran todos los productos registrados.

![image](https://user-images.githubusercontent.com/40668021/93691718-224e5080-faaf-11ea-8bd0-db92ed9d5408.png)


Se puede realizar búsqueda por nombre, registrar, modificar o eliminar productos.

![image](https://user-images.githubusercontent.com/40668021/93691752-79ecbc00-faaf-11ea-8727-44d425d39879.png)

## Venta
En esta vista se debe seleccionar los productos que el cliente desea comprar y también seleccionar el cliente que realiza la compra.

![image](https://user-images.githubusercontent.com/40668021/93691754-7d804300-faaf-11ea-9ecb-d26d800a9957.png)

Al realizar la venta se genera una factura, la cual puede ser guardada en diferentes formatos (.jpg, pdf entre otros) o impresa (debe tener conectado el dispositivo)

![image](https://user-images.githubusercontent.com/40668021/93691780-ca641980-faaf-11ea-9d8f-b8f9d8cfce34.png)

**Nota:** La dirección y el telélefono son ficticios.

## Inventario
Es una vista sencilla, cuyo objetivo es facilitar la visualización del inventario del negocio, para así, saber si necesitamos más unidades de un producto en específico.

![image](https://user-images.githubusercontent.com/40668021/93691791-fed7d580-faaf-11ea-8303-cd1288ac9fae.png)

## Transacciones
Se muestra las ventas realizadas, de la más reciente a las más antigua. Estas ventas se pueden modificar en el caso de que el
usuario desea realizar el reembolso de algún producto.

![image](https://user-images.githubusercontent.com/40668021/93691803-2c248380-fab0-11ea-8785-2f1fbef68297.png)

 Para devolver un producto se hace click sobre la columna de cantidad, se ingresa la cantidad que quedaría con la devolución (ejem: si devuelve 1 desgrasante se debe escribir 3) 

![image](https://user-images.githubusercontent.com/40668021/93691807-30e93780-fab0-11ea-9210-cd6fb2ff7014.png)

## Reportes

En esta vista se muestran un reporte sobre las ventas, ganancias del día y también un reporte total (desde que se implementa la aplicación).

![image](https://user-images.githubusercontent.com/40668021/93691832-989f8280-fab0-11ea-9c9a-a3e6d3714351.png)

![image](https://user-images.githubusercontent.com/40668021/93691834-99d0af80-fab0-11ea-9291-dd2c277546ae.png)


## Autores

- Shamir Duran.   Contacto: shamirduran15@gmail.com
- Nicolas Galvan. Contacto: nicogalvan1@hotmail.com


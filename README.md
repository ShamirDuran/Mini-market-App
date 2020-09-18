# Mini-market-App

Mini Market es una aplicación desarrollada con el objetivó
de servir como apoyo a los negocios en crecimiento para que
puedan dar el salto a la transformación digital fácilmente.

Con Mini market podrán llevar el control de su inventario, clientes,
ventas ayudando así a que se tomen mejores decisiones empresariales
y el negocio crezca.

**Desarrollada en 2020 utilizando Apache NetBeans IDE 12.0**

## Tecnología usadas en el proyecto
* **JasperReport** para generar la vista de factura.
* **JFreeChart:** para generar las gráficas de los reportes.

Y algunas otras librerias que se ya vienen en el proyecto.

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


## Autores

- Shamir Duran.   Contacto: shamirduran15@gmail.com
- Nicolas Galvan. Contacto: nicogalvan1@hotmail.com

## Instrucciones

Al ejecutar la aplicación se muestra un menu con las diferentes opciones que hay. Al hacer click en alguna opción se
muestra su respectiva interfaz para que se ueda interactuar.
<br><br>
En las interfaces se dejaron mensajes para ayudar al usuario a utilizar algunas interfaces que necesitan seguir ciertos pasos.

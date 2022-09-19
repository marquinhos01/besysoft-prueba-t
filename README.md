# Besysoft
* prueba tecnica

_Marcos Ernesto Cardozo_

**Dominio del problema:**


*Deberá implementarse la funcionalidad básica de una tienda de productos:
- Se podrán almacenar productos (código, nombre, precio, categoría), vendedor (código, nombre, sueldo).
- Al registrar una venta, se tendrá que relacionar el producto con el vendedor que realizo la venta. 
- Se debe de poder calcular la comisión de ventas por cada vendedor, el cual se obtiene de un 5% de las ventas realizadas en el caso de vender hasta dos productos y un 10% al vender más de dos productos.
- Debe implementarse distintos tipos de buscadores de productos, por ejemplo, el buscar por categoría.
- La aplicación tendrá que implementar el manejo de excepciones correctamente.
- Deberá diseñarse un Diagrama de Entidad Relación para la solución.
- Deberá ejecutarse por consola y se almacenarán los datos en memoria.




**Supuestos básicos tomados:**


_¿Quién ingresa productos?_

Un vendedor podrá ingresar productos, debe ser un vendedor con un código registrado anteriormente (existente), por ende, primero ingresare al vendedor y luego sus productos.

_¿Quién realiza la compra?_

El almacén es de acceso público, no tiene ninguna restricción al tipo de usuario. Cualquier usuario podrá ver los productos y comprarlos.

__¿El filtro de búsqueda de productos, en qué se basa?__

-Por ahora en que categoría se busca, el precio menor y precio mayor.


**Requerimientos funcionales**

    -Se podrán almacenar a vendedores ingresando su nombre y sueldo.
    -El vendedor podrá ingresar productos ingresando su nombre, precio y categoría, los productos estarán a su nombre.
    -El vendedor podrá realizar una venta y se le asocia el producto que vendió.
    -Se debe calcular la comisión de cada vendedor; si vendió hasta dos productos se debe calcular un 5% de cada venta, en caso de vender más de dos productos un 10% por cada producto vendido.
**Requerimientos no funcionales**

    -Se podrá buscar los productos por categorías para ayudar a una mejor visualización; “categorías, precios menores a…”.
    -El programa debe ejecutarse por consola.
    -El programa almacenara datos en la memoria. 


 _Entidades encontradas:_
    
    .Producto
    .Almacén
    .Vendedor

**Algunas prácticas implementadas en el proyecto:**
-Se realizó una búsqueda de requerimientos funcionales y no funcionales, se utilizó supuestos ya que no se quería molestar durante los días no laborales sábado y domingo.
-Se hizo un diagrama de clases con las entidades encontradas.
-Se utilizo la separación de capas MVC.
-Se logro hacer algunos test unitarios de la clase Almacen.
-Se logro hacer algunos test unitarios de la clase Producto.
-Se logro hacer algunos test unitarios de la clase Vendedor.
-Se utilizo git para una mejor administracion del codigo.

**Dificultades encontradas**
-EL manejo de excepciones no lo tenia muy claro, lo aprendi mas en profundidad durante el proyecto.
-La impresión por consola no es la mas amigable a la vista, pero cumple su función.













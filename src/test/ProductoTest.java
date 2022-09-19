package test;

import Excepciones.ExcepcionesProducto;
import Model.Producto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoTest {

    @Test
     public void crearProductoCorrecto() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 2000, "Tecnología");
        assertNotNull(producto);
    }
    @Test(expected = ExcepcionesProducto.class)
    public void crearProductoNombreNullo() throws ExcepcionesProducto {
        Producto producto = new Producto(null, 2000, "Tecnología");
    }
    @Test(expected = ExcepcionesProducto.class)
    public void crearProductoNombreVacio() throws ExcepcionesProducto {
        Producto producto = new Producto("", 2000, "Tecnología");
    }
    @Test(expected = ExcepcionesProducto.class)
    public void crearProductoCategoriaNullo() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 2000, null);
    }
    @Test(expected = ExcepcionesProducto.class)
    public void crearProductoCategoriaVacio() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 2000, "");
    }
    @Test(expected = ExcepcionesProducto.class)
    public void crearProductoPrecioMenorAcero() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 0, "Tecnología");
    }
    @Test
    public void productosIguales() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 200, "Tecnología");
        Producto producto2 = new Producto("Ratón", 100, "Juguetes");
        producto.setCodigo(1);
        producto2.setCodigo(1);
        assertEquals(producto, producto2);
    }
    @Test
    public void codigosDiferentes() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 200, "Tecnología");
        Producto producto2 = new Producto("Ratón", 100, "Juguetes");
        assertTrue(producto.getCodigo() != producto2.getCodigo());
    }
    @Test
    public void productosDiferentes() throws ExcepcionesProducto {
        Producto producto = new Producto("Mouse", 200, "Tecnología");
        Producto producto2 = new Producto("Ratón", 100, "Juguetes");
        assertTrue(producto != producto2);
    }

}

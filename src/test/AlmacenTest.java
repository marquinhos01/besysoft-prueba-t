package test;
import Excepciones.ExcepcionesAlmacen;
import Excepciones.ExcepcionesProducto;
import Excepciones.ExcepcionesVendedor;
import Model.Almacen;
import Model.Producto;
import Model.Vendedor;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlmacenTest {

    private Almacen almacen;
    Vendedor v1;
    Vendedor v2;

    Producto p1;
    Producto p2;

    @Before
    public void Inicio(){
        almacen = new Almacen();
        try {
            v1 = new Vendedor("Marcos", 7300);
            v2 = new Vendedor("Lucas", 6900);
        } catch (ExcepcionesVendedor e) {
            System.out.println(e);
        }

        try {
            p1 = new Producto("Mouse", 4500, "Tecnologia");
            p2 = new Producto("Remera", 2300, "Indumentaria");
        } catch (ExcepcionesProducto e) {
            System.out.println(e);
        }

    }

    @Test
    public void ingresarVendedorCorrectamente(){
        try {
            almacen.ingresarVendedor(v1);
            almacen.ingresarVendedor(v2);
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        assertTrue(almacen.verVendedores().size()==2);
        assertTrue(almacen.getVendedoresYpoductos().size() == 2);
    }
    @Test
    public void ingresarVendedorMismoCodigo(){
        try {
            v1.setCodigo(1);
            almacen.ingresarVendedor(v1);
            v2.setCodigo(1);
            almacen.ingresarVendedor(v2);
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        assertEquals(1,almacen.verVendedores().size());
        assertEquals(1,almacen.getVendedoresYpoductos().size());
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void ingresarVendedorNulo() throws ExcepcionesAlmacen {
            Vendedor v = null;
            almacen.ingresarVendedor(v);
    }
    @Test
    public void ingresarProductoCorrectamente(){
        try {
            almacen.ingresarProducto(1,p1);
            almacen.ingresarProducto(1,p2);
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        HashMap<Vendedor, LinkedList<Producto>> vendedorYproductos = new HashMap<Vendedor, LinkedList<Producto>>();
        LinkedList<Producto> productos = new LinkedList<Producto>();
        productos.add(p1);
        productos.add(p2);

        assertTrue(vendedorYproductos.equals(almacen.getVendedoresYpoductos()));
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void ingresarProductoCodigoMenorAcero() throws ExcepcionesAlmacen {
        almacen.ingresarProducto(0,p2);

    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void ingresarProductonulo() throws ExcepcionesAlmacen {
        almacen.ingresarProducto(1,null);

    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void ingresarProductoSinVendedor() throws ExcepcionesAlmacen {
       almacen.ingresarProducto(1,p1);
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void ingresarProductoYaExistente() throws ExcepcionesAlmacen {
        almacen.ingresarVendedor(v1);
        almacen.ingresarProducto(1,p1);
        almacen.ingresarProducto(1,p1);
    }
    @Test
    public void verProductos() {
        try {
            v1.setCodigo(1);
            almacen.ingresarVendedor(v1);
            almacen.ingresarProducto(1,p1);
            almacen.ingresarProducto(1,p2);
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        LinkedList<Producto> productosAux = new LinkedList<Producto>();
        productosAux.add(p1);
        productosAux.add(p2);
        assertEquals(productosAux, almacen.verProductos());
    }
    @Test
    public void verVendedores() {
        try {
            almacen.ingresarVendedor(v1);
            almacen.ingresarVendedor(v2);
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        LinkedList<Vendedor> vendedoresAux = new LinkedList<Vendedor>();
        vendedoresAux.add(v1);
        vendedoresAux.add(v2);
        assertEquals(vendedoresAux, almacen.verVendedores());
    }
    @Test
    public void verProductosCategoriaCorrecto() {
        try {
            v1.setCodigo(1);
            almacen.ingresarVendedor(v1);
            almacen.ingresarProducto(1,p1);
            almacen.ingresarProducto(1,p2);

        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }
        LinkedList<Producto> productosAux = new LinkedList<Producto>();
        productosAux.add(p1); //Categoria tecnologia

        try {
            assertEquals(productosAux,almacen.verProductosCategoria("Tecnologia"));
        } catch (ExcepcionesAlmacen e) {
            System.out.println(e);
        }

    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void verProductoscCategoriaVacia() throws ExcepcionesAlmacen {
        almacen.verProductosCategoria("");
    }
    @Test
    public void verProductoscPrecioMenorCorrecto() throws ExcepcionesAlmacen {
        //productos menor a 2500 (1)
        LinkedList<Producto>productoAux = new LinkedList<Producto>();
        productoAux.add(p2);
        v1.setCodigo(1);
        almacen.ingresarVendedor(v1);
        almacen.ingresarProducto(1,p1);
        almacen.ingresarProducto(1,p2);
        assertEquals(almacen.verProductosPrecioMenor(2500), productoAux);
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void verProductoscPrecioMenorCero() throws ExcepcionesAlmacen {
        almacen.verProductosPrecioMenor(0);
    }
    @Test
    public void verProductoscPrecioMayorCorrecto() throws ExcepcionesAlmacen {
        LinkedList<Producto>productoAux = new LinkedList<Producto>();
        v1.setCodigo(1);
        productoAux.add(p1);
        almacen.ingresarVendedor(v1);
        almacen.ingresarProducto(1,p1);
        almacen.ingresarProducto(1,p2);
        assertEquals(almacen.verProductosPrecioMayor(2500), productoAux);
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void verProductoscPrecioMenorCero2() throws ExcepcionesAlmacen {
        almacen.verProductosPrecioMayor(0);
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void venderProductoCodigoVendedorNoExiste() throws ExcepcionesAlmacen {
        almacen.venderProducto(1,1);
    }
    @Test(expected = ExcepcionesAlmacen.class)
    public void venderProductoCodigoProductoNoExiste() throws ExcepcionesAlmacen {
        almacen.venderProducto(1,1);
    }
    @Test
    public void venderProductoCorrecto(){
        try {

            Producto producto1 = new Producto("mouse", 900, "tecnologia");
            Producto producto2 = new Producto("tv", 120, "tecnologia");
            Producto producto3 = new Producto("linterna", 90, "hogar");

            Vendedor vendedor1 = new Vendedor("Marcos", 300);
            vendedor1.setCodigo(1);
            producto1.setCodigo(1);
            producto2.setCodigo(2);
            producto3.setCodigo(3);
            almacen.ingresarVendedor(vendedor1);
            System.out.println(almacen.getVendedoresYpoductos());

            almacen.ingresarProducto(1,producto1);
            almacen.ingresarProducto(1,producto2);
            almacen.ingresarProducto(1,producto3);

            almacen.venderProducto(1,1);
            almacen.venderProducto(1,2);



            //Acá ya tengo datos de venta. tengo un hash
            //Creo uno manualmente

            ;

            assertEquals(almacen.venderProducto(1,3),hashAuxiliar(vendedor1));

        } catch (ExcepcionesProducto e) {
            throw new RuntimeException(e);
        }
        catch (ExcepcionesVendedor e) {
            throw new RuntimeException(e);
        }
        catch (ExcepcionesAlmacen e) {
            throw new RuntimeException(e);
        }

    }

    private static HashMap<Vendedor, LinkedList<Producto>> hashAuxiliar(Vendedor vendedor1) throws ExcepcionesProducto, ExcepcionesVendedor {
        Producto producto1Aux = new Producto("mouse", 900, "tecnologia");
        Producto producto2Aux = new Producto("tv", 120, "tecnologia");
        Producto producto3Aux = new Producto("linterna", 90, "hogar");

        producto1Aux.setCodigo(1);
        producto2Aux.setCodigo(2);
        producto3Aux.setCodigo(3);
        Vendedor vendedor1Aux = new Vendedor("Marcos", 300);
        vendedor1Aux.setCodigo(1);

        LinkedList<Producto> vendidos = new LinkedList<Producto>();
        producto1Aux.setVendido(true);
        producto2Aux.setVendido(true);
        producto3Aux.setVendido(true);
        vendedor1Aux.setSueldo(producto1Aux.getPrecio());
        vendedor1Aux.setSueldo(producto2Aux.getPrecio());
        vendedor1Aux.setSueldo(producto3Aux.getPrecio());
        vendidos.add(producto1Aux);
        vendidos.add(producto2Aux);
        vendidos.add(producto3Aux);

        HashMap<Vendedor, LinkedList<Producto>> aux = new HashMap<Vendedor, LinkedList<Producto>>();
        aux.put(vendedor1Aux, vendidos);
        return aux;
    }
    @Test
    public void devolverComisionDosProductos(){
        try {
            v1.setCodigo(1);
            p1.setCodigo(1);
            p2.setCodigo(2);
            almacen.ingresarVendedor(v1);
            almacen.ingresarProducto(1, p1);
            almacen.ingresarProducto(1,p2);
            almacen.venderProducto(1,1);
            almacen.venderProducto(1,2);
            assertEquals(almacen.devolverComision(1),(double)340, 0.001);
        } catch (ExcepcionesAlmacen e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void devolverComisionTresProductos(){
        try {
            Producto p3 = new Producto("taza",300,"hogar");
            p3.setCodigo(3);
            v1.setCodigo(1);
            p1.setCodigo(1);
            p2.setCodigo(2);
            almacen.ingresarVendedor(v1);
            almacen.ingresarProducto(1, p1);
            almacen.ingresarProducto(1,p2);
            almacen.ingresarProducto(1,p3);
            almacen.venderProducto(1,1);
            almacen.venderProducto(1,2);
            almacen.venderProducto(1,3);
            assertEquals(almacen.devolverComision(1),(double)710, 0.001);
        } catch (ExcepcionesAlmacen e) {
            throw new RuntimeException(e);
        }
        catch (ExcepcionesProducto e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void devolverComisionCeroVendidos(){
        try {
            v1.setCodigo(1);
            almacen.ingresarVendedor(v1);
            assertEquals(almacen.devolverComision(1),(double)0, 0.001);
        } catch (ExcepcionesAlmacen e) {
            throw new RuntimeException(e);
        }

    }

}

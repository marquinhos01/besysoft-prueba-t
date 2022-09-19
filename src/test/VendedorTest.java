package test;

import Excepciones.ExcepcionesVendedor;
import Model.Vendedor;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendedorTest {

    @Test
    public void crearVendedorCorrecto() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("Marcos", 2000);
        assertNotNull(vendedor);
    }
    @Test(expected = ExcepcionesVendedor.class)
    public void crearVendedorNombreVacio() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("", 2000);
    }
    @Test(expected = ExcepcionesVendedor.class)
    public void crearVendedorSueldoMenorAcero() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("", 0);
    }
    @Test
    public void vendedoresIguales() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("Marcos", 10);
        Vendedor vendedor2 = new Vendedor("Liliana", 20);
        vendedor.setCodigo(1);
        vendedor2.setCodigo(1);
        assertTrue(vendedor.equals(vendedor2));
    }
    @Test
    public void codigosDiferentes() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("Marcos", 10);
        Vendedor vendedor2 = new Vendedor("Liliana", 20);
        assertTrue(!vendedor.getCodigo().equals(vendedor2.getCodigo()));
    }
    @Test
    public void vendedoresDiferentes() throws ExcepcionesVendedor {
        Vendedor vendedor = new Vendedor("Marcos", 10);
        Vendedor vendedor2 = new Vendedor("Liliana", 20);
        assertTrue(!vendedor.equals(vendedor2));
    }


}

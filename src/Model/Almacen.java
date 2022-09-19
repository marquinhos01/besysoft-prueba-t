package Model;

import Excepciones.ExcepcionesAlmacen;
import Excepciones.ExcepcionesProducto;
import Excepciones.ExcepcionesVendedor;

import java.util.*;
import java.util.stream.Collectors;

public class Almacen {

   private List<Producto> productos;
    private List<Vendedor>vendedores;
    private HashMap<Vendedor, LinkedList<Producto>> bienesVendedores;
    public Almacen(){
        vendedores = new LinkedList<Vendedor>(); //lograr O(1) en contains
        productos = new LinkedList<Producto>(); //lograr O(1) en contains && O(n) en filtrados
        bienesVendedores = new HashMap<Vendedor, LinkedList<Producto>>(); //ver productos de vendedores
    }

    public boolean ingresarVendedor(Vendedor vendedor) throws ExcepcionesAlmacen { // O(1)
        if(vendedor == null){
            throw new ExcepcionesAlmacen("El vendedor no puede ser nulo");
        }
        if(vendedores.contains(vendedor) || bienesVendedores.containsKey(vendedor)){
            throw new ExcepcionesAlmacen("El vendedor ya existe en el sistema");
        }
        bienesVendedores.put(vendedor, new LinkedList<Producto>());
        return vendedores.add(vendedor);
    }
    public boolean ingresarProducto(Integer codigoVendedor, Producto producto) throws ExcepcionesAlmacen { // O(1)
        if(codigoVendedor <= 0){
            throw new ExcepcionesAlmacen("El codigo del vendedor debe ser mayor a 0");
        }
        if(producto == null){
            throw new ExcepcionesAlmacen("El producto no debe ser nulo");
        }
        Vendedor vendedorAux = getAuxVendedor(codigoVendedor);

        if(!bienesVendedores.containsKey(vendedorAux)){
            throw new ExcepcionesAlmacen("Antes de ingresar el producto debe ingresar el vendedor, ese vendedor no existe.");
        }
        if(productos.contains(producto)){
            throw new ExcepcionesAlmacen("El producto ya existe en el sistema");
        }
        bienesVendedores.get(vendedorAux).add(producto);
        return productos.add(producto);
    }
    public List<Producto> verProductos(){ // O(1)
        return productos;
    } //O(1)
    public List<Vendedor> verVendedores() { // O(1)
        return vendedores;
    } //O(1)
    public List<Producto> verProductosCategoria(String cat) throws ExcepcionesAlmacen { // O(n)
      if(cat.equals("") || cat == null){
          throw new ExcepcionesAlmacen("La categoria no debe estar vacia ni ser nula");
      }
       return productos.stream().filter(producto -> producto.getCategoria().equals(cat)).collect(Collectors.toList());
    }
    public List<Producto>  verProductosPrecioMenor(Integer precio) throws ExcepcionesAlmacen { // O(n)
        if(precio <= 0){
            throw new ExcepcionesAlmacen("El precio debe ser mayor a 0");
        }
        return productos.stream().filter(producto -> producto.getPrecio()<precio).collect(Collectors.toList());
    }
    public List<Producto>  verProductosPrecioMayor(Integer precio) throws ExcepcionesAlmacen { // O(n)
        if(precio <= 0){
            throw new ExcepcionesAlmacen("El precio debe ser mayor a 0");
        }
        return productos.stream().filter(producto -> producto.getPrecio()>precio).collect(Collectors.toList());
    }
    public HashMap<Vendedor, LinkedList<Producto>> venderProducto(Integer codigoVendedor, Integer codigoProducto) throws ExcepcionesAlmacen { //O(n)
        Vendedor vendedorAux = getAuxVendedor(codigoVendedor);
        Producto productoAux = getAuxProducto(codigoProducto);

        if(!bienesVendedores.containsKey(vendedorAux)){
            throw new ExcepcionesAlmacen("El codigo de vendedor no existe, no va a poder vender ningun producto.");
        }
        if(!productos.contains(productoAux)){
            throw new ExcepcionesAlmacen("El codigo de producto no existe, no va a poder venderlo.");
        }
        Optional<Producto> prod = bienesVendedores.get(vendedorAux).stream().
                filter(p -> p.getCodigo().equals(codigoProducto) && !p.isVendido()).
                findFirst();
        Producto p = prod.orElse(null); //Tengo el producto de ese vendedor

        if(p != null){
            Optional<Vendedor> vend = vendedores.stream().filter(v -> v.equals(vendedorAux)).findFirst();
            Vendedor v = vend.get();
            v.setSueldo(p.getPrecio());
            p.setVendido(true);
            HashMap<Vendedor, LinkedList<Producto>> aux = bienesVendedores;
            return aux;
        }
        throw new ExcepcionesAlmacen("Ese producto ya está vendido");
    }
    public double devolverComision(Integer codigo){
        Vendedor aux = getAuxVendedor(codigo);
        int cantidadDeVentas = (int)bienesVendedores.get(aux).stream().filter(p -> p.isVendido()).count();
        double ventas = bienesVendedores.get(aux).stream().filter(venta -> venta.isVendido()==true).mapToDouble(p -> p.getPrecio()).sum();
        if(cantidadDeVentas <= 2)
            return ventas * 5/100;
        if(cantidadDeVentas > 2)
            return ventas * 10/100;
        return ventas;
    }


    private static Producto getAuxProducto(Integer codigoProducto) { //O(1)
        Producto productoAux = null;
        try {
            productoAux = new Producto("aux", 1, "aux");
        } catch (ExcepcionesProducto e) {
            System.out.println(e);
        }
        productoAux.setCodigo(codigoProducto);
        return productoAux;
    }

    private static Vendedor getAuxVendedor(Integer codigoVendedor) { //O(1)
        Vendedor vendedorAux = null; //crea un nuevo vendedor, no importa los atributos
        try {
            vendedorAux = new Vendedor("aux", 1);
        } catch (ExcepcionesVendedor e) {
            System.out.println(e);
        }
        vendedorAux.setCodigo(codigoVendedor); // El vendedor se va a comparar con el codigo como está en el @override equals
        return vendedorAux;
    }
    public Map<Vendedor, LinkedList<Producto>> getVendedoresYpoductos(){
        return bienesVendedores;
    } //O(1)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return Objects.equals(bienesVendedores, almacen.bienesVendedores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bienesVendedores);
    }
}

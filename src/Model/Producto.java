package Model;

import Excepciones.ExcepcionesProducto;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Producto {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer codigo;
    private String nombre;
    private double precio;
    private String categoria;
    private boolean vendido = false;

    public Producto(String nombre, double precio, String categoria) throws ExcepcionesProducto {
        if(nombre == null || nombre.equals("") || categoria == null || categoria.equals("")) {
            throw new ExcepcionesProducto("Los campos no deben ser nulos");
        }
        if(precio <= 0){
            throw new ExcepcionesProducto("El precio debe ser mayor a cero");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;

        codigo = count.incrementAndGet();
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public Integer getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isVendido() {
        return vendido;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                "esta vendido=" + vendido + " " +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) { // equals con el código (nuncá sera igual).
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return codigo.equals(producto.codigo);
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}

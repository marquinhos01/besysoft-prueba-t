package Model;

import Excepciones.ExcepcionesVendedor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Vendedor {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer codigo;
    private String nombre;
    private double sueldo;

    public Vendedor(String nombre, double sueldo) throws ExcepcionesVendedor {
        if(nombre.equals("")|| nombre == null){
            throw new ExcepcionesVendedor("El nombre debe no debe estar vacio, ni ser nullo.");
        }
        if(sueldo <= 0){
            throw new ExcepcionesVendedor("El sueldo debe ser mayor a 0.");
        }
        this.nombre = nombre;
        this.sueldo = sueldo;
        codigo = count.incrementAndGet();
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo += sueldo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return codigo.equals(vendedor.codigo);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}' + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}

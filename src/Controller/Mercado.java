package Controller;

import Excepciones.ExcepcionesAlmacen;
import Excepciones.ExcepcionesProducto;
import Excepciones.ExcepcionesVendedor;
import Model.Producto;
import Model.Vendedor;
import Model.Almacen;
import View.CompraView;

import java.util.Scanner;

public class Mercado {
    private CompraView compraView;
    private Almacen almacen;

    public Mercado(){
        compraView = new CompraView();
        almacen = new Almacen();
    }
    public void iniciar(){
        Integer opcion;
        do {
           opcion = compraView.iniciar();
           System.out.println("Cada vez que ingrese un valor, presione enter para confirmarlo\n");
       switch (opcion){
           case 1:
               Scanner scanner = new Scanner(System.in);
               System.out.println("Ingrese nombre, luego ingrese sueldo");
               try {
                   almacen.ingresarVendedor(new Vendedor(scanner.nextLine(), scanner.nextDouble()));
               } catch (ExcepcionesVendedor e) {
                   System.out.println(e);
               } catch (ExcepcionesAlmacen e) {
                   System.out.println(e);
               }
               compraView.imprimirLista(almacen.verVendedores());
               break;

           case 2:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese codigo de vendedor, nombre de producto, precio y categoria");
               int codigo = scanner.nextInt();
               scanner = new Scanner(System.in);
               String nombre = scanner.nextLine();
               scanner = new Scanner(System.in);
               double precio = scanner.nextDouble();
               scanner = new Scanner(System.in);
               String categoria = scanner.nextLine();
                try{
                    almacen.ingresarProducto(codigo,new Producto(nombre, precio, categoria));
                    compraView.imprimirLista(almacen.verProductos());
                }
                catch (ExcepcionesProducto e){
                    System.out.println(e);
                } catch (ExcepcionesAlmacen e) {
                    System.out.println(e);
                }
               break;
           case 3:
               compraView.imprimirLista(almacen.verProductos());
               break;
           case 4:
               compraView.imprimirLista(almacen.verVendedores());
               break;
           case 5:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese categoria");
               try {
                   compraView.imprimirLista(almacen.verProductosCategoria(scanner.nextLine()));
               } catch (ExcepcionesAlmacen e) {
                   System.out.println(e);
               }
               break;
           case 6:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese precio menor");
               try {
                   compraView.imprimirLista(almacen.verProductosPrecioMenor(scanner.nextInt()));
               } catch (ExcepcionesAlmacen e) {
                   System.out.println(e);
               }
               break;
           case 7:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese precio mayor");
               try {
                   compraView.imprimirLista(almacen.verProductosPrecioMayor(scanner.nextInt()));
               } catch (ExcepcionesAlmacen e) {
                   System.out.println(e);
               }
               break;
           case 8:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese codigo de vendedor");
               int codigoVendedor = scanner.nextInt();
               System.out.println("Ingrese codigo de producto a vender");
               int codigoProducto = scanner.nextInt();
               try {
                   System.out.println(almacen.venderProducto(codigoVendedor, codigoProducto));
               } catch (ExcepcionesAlmacen e) {
                   System.out.println(e);
               }
               break;
           case 9:
               scanner = new Scanner(System.in);
               System.out.println("Ingrese codigo de vendedor");
               codigoVendedor = scanner.nextInt();
               System.out.println("Comision ganada: " + almacen.devolverComision(codigoVendedor));
               break;
       }
        }while(opcion!=0);
    }

    public static void main(String[] args) {
        Mercado m = new Mercado();
        m.iniciar();
    }

}

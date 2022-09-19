package View;

import java.util.List;
import java.util.Scanner;

public class CompraView<T> {


    public Integer iniciar(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elija una opcion:\n");
            System.out.println("1. Almacenar vendedor:\n");
            System.out.println("2. Almacenar producto a vender:\n");
            System.out.println("3. Ver productos:\n");
            System.out.println("4. Ver vendedores:\n");
            System.out.println("5. Ver productos por categoría:\n");
            System.out.println("6. Ver productos por precio menor que $:\n");
            System.out.println("7. Ver productos por precio mayor que $:\n");
            System.out.println("8. Vender producto:\n");
             System.out.println("9. Ver comision de vendedores:\n");
            System.out.println("0. Salir:\n");
            System.out.println("Digite la opcion\n");
            int opcion = scanner.nextInt();
           return opcion;
    }
    public void imprimirLista(List<T> lista){
            System.out.println(lista);

    }




}

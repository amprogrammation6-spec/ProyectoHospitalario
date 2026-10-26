package util;

import java.util.Scanner;

public class EntradaConsola {



    private static  final Scanner SCANNER = new Scanner(System.in);

    private EntradaConsola() {


    }

    public static  String leerTexto(String mensaje){
        System.out.println(mensaje);
        return SCANNER.nextLine().trim();



    }


    public static  int leerEntero(String mensaje){
        while (true) {
            try{
                System.out.println(mensaje);
                return Integer.parseInt(SCANNER.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("Debe ingresar un numero que sea entero ");
            }   
        }
    }



    public static  double leerDecimal(String mensaje){
         while (true) {
            try{
                System.out.println(mensaje);
                return Double.parseDouble(SCANNER.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("Debe ingresar un numero que sea decimal ");
            }   
        }
        

        
    }


    

    
    
}

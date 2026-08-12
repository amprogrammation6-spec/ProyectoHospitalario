package model;

public class Enfermera {

    int id;
    String nombre;
    int edad;
    String documento;


    public Enfermera(int id, String nombre, int edad, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

     public void  mostrarinformacion() {
        System.out.println("["+ id +" ] "+nombre+" | Edad:"+edad+" |  Documento: "+documento );
    }

    

















    
}

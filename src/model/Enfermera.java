package model;

public class Enfermera {

    public int id;
    public String nombre;
    public int edad;
    public String documento;


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

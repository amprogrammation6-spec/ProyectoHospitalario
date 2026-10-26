package model;

public class Paciente {

    public int id;
    public String nombre;
    public int edad;
    public String documento;


    public Paciente(int id, String nombre, int edad, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    
     public void  mostrarInformacion() {
        System.out.println("["+ id +" ] "+nombre+" | Edad:"+edad+" |  Documento: "+documento );
    }








    
}


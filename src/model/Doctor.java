package model;

public class Doctor {

    int id;
    String nombre;
    int edad;
    String documento;
    String especialidad;


    public Doctor(int id, String nombre, int edad, String documento, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.especialidad = especialidad;
    }

    public void  mostrarinformacion() {
        System.out.println("["+ id +" ] "+nombre+" | "+especialidad+" | Edad:"+edad+" |  Documento: "+documento );
    }
    


}

package model;

public class Doctor {

    public int id;
    public String nombre;
    public int edad;
    public String documento;
    public String especialidad;


    public Doctor(int id, String nombre, int edad, String documento, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.especialidad = especialidad;
    }

    public void  mostrarInformacion() {
        System.out.println("["+ id +" ] "+nombre+" | "+especialidad+" | Edad:"+edad+" |  Documento: "+documento );
    }
    


}

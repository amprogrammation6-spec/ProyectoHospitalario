package model;

public class Cita {

    int id;
    int pacienteId ;
    int doctorId;
    String fecha;
    String hora;
    String estado;


    public Cita(int id, int pacienteId, int doctorId, String fecha, String hora, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public void mostrarResumen(String nombrePaciente, String nombreDoctor) {
        System.out.println("Cita #" +id+ " | " +fecha+" - "+hora+" | Paciente: "+nombrePaciente+" | Doctor: " +nombreDoctor+ " | "+estado);



    }


    
}

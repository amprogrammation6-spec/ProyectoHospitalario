package model;

public class Cita {

    public int id;
    public int pacienteId ;
    public int doctorId;
    public String fecha;
    public String hora;
    public String estado;


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

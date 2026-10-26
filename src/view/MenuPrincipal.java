package view;

import java.sql.SQLException;

import model.Cita;
import model.Doctor;
import model.Enfermera;
import model.Paciente;
import repository.CitaRepositorio;
import repository.EnfermeraRepositorio;
import repository.PacienteRepositorio;
import repository.doctorRepositorio;
import util.EntradaConsola;

public class MenuPrincipal {

    private final PacienteRepositorio pacientes = new PacienteRepositorio();
    private final EnfermeraRepositorio enfermeras = new EnfermeraRepositorio();
    private final doctorRepositorio doctores = new doctorRepositorio();
    private final CitaRepositorio citas = new CitaRepositorio();




    public void iniciar (){
        int opcion;



        do{
            System.out.println("---HOSPITAL SAN GABRIEL---");
            System.out.println("1. Registrar pacientes");
            System.out.println("2. Registrar doctor");
            System.out.println("3. Registrar enfermera");
            System.out.println("4. Listar pacientes");
            System.out.println("5. Listar doctores");
            System.out.println("6. Crear cita");
            System.out.println("7. Ver cita");
            System.out.println("8. Cancelar cita");
            System.out.println("0. Lista Salir");

            opcion = EntradaConsola.leerEntero("Digite la opcion: ");
            System.out.println();


            try{

                switch (opcion) {
                    case 1 -> registrarPaciente();
                    case 2 -> registrarDoctor();
                    case 3 -> registrarEnfermera();
                    case 4 -> listarPacientes();
                    case 5 -> listarDoctores();
                    case 6 -> crearCitas();
                    case 7 -> verCitas();
                    case 8 -> cancelarCitas();
                    case 0 -> System.out.print("Hasta la proxima......");
                    default -> System.out.print("Opcion invalida");
                }


            }catch(SQLException e) {
                System.out.println("Error en la base de datos" + e.getMessage());
            }
            System.out.println();
        }while(opcion != 0);
    }


    private void registrarPaciente() throws SQLException{
        String nombre = EntradaConsola.leerTexto("Nombre: ");
        int edad = EntradaConsola.leerEntero("Edad: ");
        String documento = EntradaConsola.leerTexto("Documento: ");
        int id = pacientes.siguienteId();
        pacientes.guardar(new Paciente(id, nombre, edad, documento));
        System.out.println("Paciente registrado con id:  "+id);
    }


    private void registrarDoctor() throws SQLException{
        String nombre = EntradaConsola.leerTexto("Nombre: ");
        int edad = EntradaConsola.leerEntero("Edad: ");
        String documento = EntradaConsola.leerTexto("Documento: ");
        String especialidad = EntradaConsola.leerTexto("Especialidad");
        int id = doctores.siguienteId();
        doctores.guardar(new Doctor(id, nombre, edad, documento,especialidad));
        System.out.println("Doctor registrado con id:  "+id);
    }


    private void registrarEnfermera() throws SQLException{
        String nombre = EntradaConsola.leerTexto("Nombre: ");
        int edad = EntradaConsola.leerEntero("Edad: ");
        String documento = EntradaConsola.leerTexto("Documento: ");
        int id = enfermeras.siguienteId();
        enfermeras.guardar(new Enfermera(id, nombre, edad, documento));
        System.out.println("Enfermera registrad con id:  "+id);
    }


    private void listarPacientes() throws SQLException{
        var lista = pacientes.listarTodos();
        if (lista.isEmpty()){
            System.out.println("No hay pacientes");
            return ;
        }
        for(Paciente p : lista){
            p.mostrarInformacion();
        }
    }


    private void listarDoctores() throws SQLException{
        var lista = doctores.listarTodos();
        if (lista.isEmpty()){
            System.out.println("No hay doctores");
            return ;
        }
        for(Doctor d : lista){
            d.mostrarInformacion();
        }
    }

    private void crearCitas() throws SQLException{
        int pacienteId = EntradaConsola.leerEntero("Id paciente: ");
        int doctorId = EntradaConsola.leerEntero("Id doctor: ");

        if (pacientes.buscarPorId(pacienteId) == null) {
            System.out.println("Paciente no encontrado");
            return ;
        }

        if (doctores.buscarPorId(doctorId) == null) {
            System.out.println("Doctor no encontrado");
            return ;
        }

        String fecha = EntradaConsola.leerTexto("fecha (AAAA-MM-DIA): ");
        String hora = EntradaConsola.leerTexto("hora (HH:MM): ");
        int id = citas.siguienteId();
        citas.guardar(new Cita(id, pacienteId, doctorId, fecha, hora, "PROGRAMADA"));
        System.out.println("Cita creada con el Id: "+id);
    }

    private  void verCitas() throws SQLException{
        var lista = citas.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay citas");
            return ;
        }
         for(Cita cita : lista){
            String nomPac = "Desconocido";
            String nomDoc = "Desconocido";
            Paciente p = pacientes.buscarPorId(cita.pacienteId);
            Doctor d = doctores.buscarPorId(cita.doctorId);
            if(p != null) 
                nomPac = p.nombre;
            if(d != null)
                nomDoc = d.nombre;
            cita.mostrarResumen(nomPac, nomDoc);
        }
    }


    private void cancelarCitas() throws SQLException{
        int id = EntradaConsola.leerEntero("Id de la cita: ");
        Cita cita = citas.buscarPorId(id);
        if (cita == null) {
            System.out.println("Cita no encontrada");
            return ;
        }

        cita.estado = "CANCELADA";
        citas.guardar(cita);
        System.out.println("Cita cancelada ");
    }
}
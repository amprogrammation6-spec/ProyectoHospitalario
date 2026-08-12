package repository;

import java.sql.SQLException;

import model.Paciente;

public class PacienteRepositorio {



    public int siguienteId () throws SQLException {
        return maxId("pacientes") + 1;

    }

    //guardar un paciente en sql
    // si el id ya existe, actuaLice los datos ( ON DUPLICATE KEY UPDATE)
    
    public void guardar(Paciente p) {
        String sql = """
                INSERT INTO pacientes(id, nombre, edad, documento) VALUES (?,?,?,?)
                ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), edad=VALUES(edad), documento=VALUES(docuemnto)
                """;

    }
    



private int maxId() {





  }












}

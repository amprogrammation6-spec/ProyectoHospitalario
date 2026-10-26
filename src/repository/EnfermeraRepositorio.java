package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;
import model.Enfermera;
import model.Paciente;
import util.conexionBD;

public class EnfermeraRepositorio {



    public int siguienteId () throws SQLException {
        return maxId() + 1;

    }




    public void guardar(Enfermera e) throws SQLException{
        String sql = """
                INSERT INTO enfermeras (id, nombre, edad, documento) VALUES (?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), edad=VALUES(edad), documento=VALUES(docuemnto),
                       especialidad=VALUES(especialidad)
                """;


                //abrir conexion y que luego el proceso se cierre automaticamente
                try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(sql)){
                        ps.setInt(1, e.id);
                        ps.setString(2, e.nombre);
                        ps.setInt(3, e.edad);
                        ps.setString(4, e.documento);
                        ps.executeUpdate();


                    }
    }



      public List<Enfermera> listarTodos() throws SQLException{
        List<Enfermera> lista = new ArrayList<>();
        try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(
                        "SELECT id, nombre,edad,docuemnto FROM enfermeras ORDER BY id");
                    ResultSet rs = ps.executeQuery()){
                            //avance fila por fila 
                            while (rs.next()){
                                lista.add(new Enfermera(rs.getInt("id"), rs.getString("nombre"),
                                    rs.getInt("edad"), rs.getString("documento")));

                            }
                        }
                        return lista; 
    }






        private int maxId() throws SQLException{
    try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                    "SELECT COALESCE(MAX(id),0) AS m FROM doctores");
                    ResultSet rs = ps.executeQuery()){
                        rs.next();
                        return rs.getInt("m");
        
        }
    }

    
}

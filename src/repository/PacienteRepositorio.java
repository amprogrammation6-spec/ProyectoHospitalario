package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;
import util.conexionBD;

public class PacienteRepositorio {



    public int siguienteId () throws SQLException {
        return maxId("pacientes") + 1;

    }

    //guardar un paciente en sql
    // si el id ya existe, actuaLice los datos ( ON DUPLICATE KEY UPDATE)
    
    public void guardar(Paciente p) throws SQLException{
        String sql = """
                INSERT INTO pacientes(id, nombre, edad, documento) VALUES (?,?,?,?)
                ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), edad=VALUES(edad), documento=VALUES(docuemnto)
                """;


                //abrir conexion y que luego el proceso se cierre automaticamente
                try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(sql)){
                        ps.setInt(1, p.id);
                        ps.setString(2, p.nombre);
                        ps.setInt(3, p.edad);
                        ps.setString(4, p.documento);
                        ps.executeUpdate();


                    }
            

    }

    public List<Paciente> listarTodos() throws SQLException{
        List<Paciente> lista = new ArrayList<>();
        try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(
                        "SELECT id, nombre,edad,docuemnto FROM pacientes ORDER BY id");
                    ResultSet rs = ps.executeQuery()){
                            //avance fila por fila 
                            while (rs.next()){
                                lista.add(new Paciente(rs.getInt("id"), rs.getString("nombre"),
                                    rs.getInt("edad"), rs.getString("documento")));

                            }
                        }
                                return lista; 
    }

    public Paciente buscarPorId(int id) throws SQLException{
        try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                        "SELECT id, nombre,edad,docuemnto FROM pacientes WHERE id=?")){
            ps.setInt( 1,id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Paciente (rs.getInt("id"), rs.getString("nombre"),
                                    rs.getInt("edad"), rs.getString("documento"));
                }

            }
            

        }
        return null;

    }
    
    private int maxId(String tabla) throws SQLException{
    try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                    "SELECT COALESCE(MAX(id),0) AS m FROM "+tabla);
                    ResultSet rs = ps.executeQuery()){
                        rs.next();
                        return rs.getInt("m");
        
        }
    }

}

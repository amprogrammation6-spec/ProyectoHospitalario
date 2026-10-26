package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;
import util.conexionBD;

public class doctorRepositorio {

    public int siguienteId () throws SQLException {
        return maxId() + 1;

    }


      public void guardar(Doctor d) throws SQLException{
        String sql = """
                INSERT INTO doctores (id, nombre, edad, documento, especialidad) VALUES (?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), edad=VALUES(edad), documento=VALUES(documento),
                       especialidad=VALUES(especialidad)
                """;


                //abrir conexion y que luego el proceso se cierre automaticamente
                try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(sql)){
                        ps.setInt(1, d.id);
                        ps.setString(2, d.nombre);
                        ps.setInt(3, d.edad);
                        ps.setString(4, d.documento);
                        ps.setString(5, d.especialidad);
                        ps.executeUpdate();


                    }
    }


        public List<Doctor> listarTodos() throws SQLException{
        List<Doctor> lista = new ArrayList<>();
        try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(
                        "SELECT id, nombre,edad,documento, especialidad FROM doctores ORDER BY id");
                    ResultSet rs = ps.executeQuery()){
                            //avance fila por fila 
                            while (rs.next()){
                                lista.add(new Doctor(rs.getInt("id"), rs.getString("nombre"),
                                    rs.getInt("edad"), rs.getString("documento"), rs.getString("especialidad")));

                            }
                        }
                        return lista; 
    }



    public Doctor buscarPorId(int id) throws SQLException{
        try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                        "SELECT id, nombre,edad,documento,especialidad FROM doctores WHERE id=?")){
            ps.setInt( 1,id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Doctor (rs.getInt("id"), rs.getString("nombre"),
                                    rs.getInt("edad"), rs.getString("documento"), rs.getString("especialidad"));
                }

            }
            

        }
        return null;

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

package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cita;
import model.Paciente;
import util.conexionBD;

public class CitaRepositorio {


     public int siguienteId () throws SQLException {
        return maxId() + 1;

    }


    public void guardar(Cita cita) throws SQLException{
        String sql = """
                INSERT INTO citas (id, paciente_id, doctor_id, fecha, hora, estado) VALUES (?,?,?,?,?,?)
                ON DUPLICATE KEY UPDATE 
                    paciente_id=VALUES(paciente_id), 
                    doctor_id=VALUES(doctor_id),
                    fecha=VALUES(fecha),
                    hora=VALUES(hora),
                    estado=VALUES(estado)
                """;


                //abrir conexion y que luego el proceso se cierre automaticamente
                try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(sql)){
                        ps.setInt(1, cita.id);
                        ps.setInt(2, cita.paciente_id);
                        ps.setInt(3, cita.doctor_id);
                        ps.setString(4, cita.fecha);
                        ps.setString(5, cita.hora);
                        ps.setString(6, cita.estado);
                        ps.executeUpdate();


                    }
            

    }


    public List<Cita> listarTodos() throws SQLException{
        List<Cita> lista = new ArrayList<>();
        try(Connection c = conexionBD.obtenerConexion();
                    PreparedStatement ps = c.prepareStatement(
                        "SELECT id, paciente_id, doctor_id, fecha, hora, estado FROM citas ORDER BY fecha, hora");
                    ResultSet rs = ps.executeQuery()){
                            //avance fila por fila 
                            while (rs.next()){
                                lista.add(new Cita(rs.getInt("id"),rs.getInt("paciente_id"),rs.getInt("doctor_id"), rs.getString("fecha"),
                                    rs.getString("hora"), rs.getString("estado")));

                            }
                        }
                        return lista; 
    }


    public Cita buscarPorId(int id) throws SQLException{
        try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                        "SELECT id, paciente_id, doctor_id, fecha, hora, estado FROM citas WHERE id=?")){
            ps.setInt( 1,id);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Cita (rs.getInt("id"), rs.getInt("paciente_id"),
                                    rs.getInt("doctor_id"), rs.getString("fecha"),
                                rs.getString("hora"),rs.getString("estado"));
                }

            }
            

        }
        return null;

    }


    













         private int maxId() throws SQLException{
    try(Connection c = conexionBD.obtenerConexion();
                PreparedStatement ps = c.prepareStatement(
                    "SELECT COALESCE(MAX(id),0) AS m FROM citas");
                    ResultSet rs = ps.executeQuery()){
                        rs.next();
                        return rs.getInt("m");
        
        }
    }



    
}

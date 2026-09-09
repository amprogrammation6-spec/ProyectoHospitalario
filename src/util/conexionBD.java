package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public final class conexionBD {

    private static final String ARCHIVO_CONFIG = "config/database.properties";

    //variables que guardan los datos de conexion 

    private static String url;
    private static String usuario;
    private static String contraseña;


    private conexionBD(){



    }

    static {
        cargarConfiguracion();
        try{
            //carga el driver de JDBC de mysql
            Class.forName("com,mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new ExceptionInInitializerError(
            "No se encontro el driver de mysql . Coloca mysql-connector-j en la carpeta lib/."+e.getMessage());

        }
    }
    private static void cargarConfiguracion(){
        Properties propiedades = new Properties();


        //abre y cierre automaticamente al terminar 
        try(FileInputStream entrada = new FileInputStream(ARCHIVO_CONFIG)){

            propiedades.load(entrada);
            url = propiedades.getProperty("db.url")
            usuario = propiedades.getProperty("db.user")
            contraseña = propiedades.getProperty("db.password","");



        }  catch (IOException e) {
            throw new ExceptionInInitializerError(
            "No se pudo leer "+ARCHIVO_CONFIG +". VERIFICA QUE EL ARCHIVO EXISTA "+e.getMessage());

            }
    }
    public static Connection obtenerConexion() throws SQLException{

        return DriverManager.getConnection(url, usuario, contraseña);
    }




}

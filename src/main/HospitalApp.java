package main;

import util.conexionBD;
import view.MenuPrincipal;

public class HospitalApp {


    public static void main(String[] args) {
        if (!conexionBD.probarConexion()){
            System.out.println("No se pudo conectar a MySQL. ");
            System.out.println("Revisa que el servidor este encendido y que");
            System.out.println("config/database.properties coincida con el Workbench. ");
            return ;
        }
        new MenuPrincipal().iniciar();
    }
}

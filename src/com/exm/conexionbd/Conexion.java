
package com.exm.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
 private static final String nbase = "gestorweb";
    private static final String usuario = "root";
    private static final String contrasenia = "luna00692";
    private static final String comando = "jdbc:mysql://localhost:3306/" + nbase +"?serverTimezone=UTC";
    

    
private Connection conect = null;

    public Connection ConexionMysql() {
        
        try {
            conect = DriverManager.getConnection(comando, usuario, contrasenia);
            if (conect != null) {
                return conect;
                
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar" + e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        Conexion co = new Conexion();
        co.ConexionMysql();
    }
}

package com.exm.controladorbd;

import com.exm.conexionbd.Conexion;
import com.exm.modelo.Papelera;
import com.exm.utilidades.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Papelerabd {

    public Utilidades utilidades;

    public Papelerabd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarPapelera(Papelera sweb) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorweb`.`papelera` (`idpapelera`, `nombre`, `url`, `fecha_registro`, `seguridad`, `fecha_actualizacion`) "
                + "VALUES ('" + String.valueOf(sweb.getIdpapelera()) + "',"
                + " '" + sweb.getNombre() + "',"
                + " '" + sweb.getUrl() + "',"
                + " '" + utilidades.devolverFecha(sweb.getFecha_registro()) + "',"
                + " '" + sweb.getSeguridad() + "',"
                + " '" + utilidades.devolverFecha(sweb.getFecha_actualizacion()) + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            return registrar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    public boolean EliminarPapelera(Papelera sweb) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `gestorweb`.`papelera` WHERE (`idpapelera` = '" + String.valueOf(sweb.getIdpapelera()) + "');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            eliminar = true;
            stm.close();
            return eliminar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }
    
    public boolean VaviarPapelera() {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "truncate table gestorweb.papelera;";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            eliminar = true;
            stm.close();
            return eliminar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    public List<Papelera> ObtenerPapelera() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.papelera;";
        List<Papelera> ListaSitiosWeb = new ArrayList<Papelera>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Papelera c = new Papelera();
                c.setIdpapelera(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
                ListaSitiosWeb.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return ListaSitiosWeb;
    }

    

    public List<Papelera> ObtenerPapeleraPorURL(String url) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.papelera where url like '%" + url + "%';";
        List<Papelera> listaPapelera = new ArrayList<>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Papelera c = new Papelera();
                c.setIdpapelera(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
                listaPapelera.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaPapelera;
    }
    
    public List<Papelera> ObtenerPapeleraPorNombre(String nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.papelera where nombre like '%" + nombre + "%';";
        List<Papelera> listaPapelera = new ArrayList<>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Papelera c = new Papelera();
                c.setIdpapelera(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
                listaPapelera.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaPapelera;
    }
}

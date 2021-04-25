/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exm.controladorbd;

import com.exm.conexionbd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.exm.modelo.SitiosWeb;
import com.exm.utilidades.Utilidades;

/**
 *
 * @author Ordenador
 */
public class SitiosWebbd {

    public Utilidades utilidades;

    public SitiosWebbd() {
        utilidades = new Utilidades();
    }

    public boolean GuardarSitioWeb(SitiosWeb sweb) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO `gestorweb`.`sitiosweb` (`idsitiosweb`, `nombre`, `url`, `fecha_registro`, `seguridad`, `fecha_actualizacion`) "
                + "VALUES ('" + String.valueOf(sweb.getIdsitiosweb()) + "',"
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

    public boolean EditarSitioWeb(SitiosWeb sweb) {
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `gestorweb`.`sitiosweb` SET"
                + " `nombre` = '"+sweb.getNombre()+"',"
                + " `url` = '"+sweb.getUrl()+"',"
                + " `seguridad` = '"+sweb.getSeguridad()+"',"
                + " `fecha_actualizacion` = '"+utilidades.devolverFecha(sweb.getFecha_actualizacion())+"' WHERE (`idsitiosweb` = '"+String.valueOf(sweb.getIdsitiosweb())+"');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            editar = true;
            stm.close();
            return editar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }

    
     public boolean FechaUltimiAcceso(SitiosWeb sweb) {
        boolean editar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE `gestorweb`.`sitiosweb` SET `fecha_ultimo_acceso` = '"+utilidades.devolverFecha(sweb.getFecha_ultimo_acceso())+"' WHERE (`idsitiosweb` = '"+String.valueOf(sweb.getIdsitiosweb())+"');";
        try {
            Conexion conexion = new Conexion();
            con = conexion.ConexionMysql();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            editar = true;
            stm.close();
            return editar;
        } catch (Exception e) {
            System.out.println("hubo algun error" + e.getMessage());

        }
        return false;
    }
    public boolean EliminarSitioWeb(SitiosWeb sweb) {
        boolean eliminar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM `gestorweb`.`sitiosweb` WHERE (`idsitiosweb` = '"+String.valueOf(sweb.getIdsitiosweb())+"');";
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

    public List<SitiosWeb> ObtenerSitiosWeb() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.sitiosweb;";
        List<SitiosWeb> ListaSitiosWeb = new ArrayList<SitiosWeb>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SitiosWeb c = new SitiosWeb();
                c.setIdsitiosweb(rs.getInt(1));
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
    
    public SitiosWeb Comparador(String url) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        SitiosWeb c = null;
        String sql = "select * from gestorweb.sitiosweb where url = '"+url+"';";
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new SitiosWeb();
                c.setIdsitiosweb(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
    }
    
    public List<SitiosWeb> ObtenerSitioWebPorURL(String url) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.sitiosweb where url like '%" + url + "%';";
        List<SitiosWeb> listaSitioweb = new ArrayList<>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SitiosWeb c = new SitiosWeb();
                c.setIdsitiosweb(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
                listaSitioweb.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaSitioweb;
    }
    
    public List<SitiosWeb> ObtenerSitioWebPrNombre(String nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "select * from gestorweb.sitiosweb where nombre = '" + nombre + "';";
        List<SitiosWeb> listaSitioweb = new ArrayList<>();
        try {
            co = new Conexion().ConexionMysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SitiosWeb c = new SitiosWeb();
                c.setIdsitiosweb(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setUrl(rs.getString(3));
                c.setFecha_registro(rs.getDate(4));
                c.setSeguridad(rs.getInt(5));
                c.setFecha_ultimo_acceso(rs.getDate(6));
                c.setFecha_actualizacion(rs.getDate(7));
                listaSitioweb.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaSitioweb;
    }
    public static void main(String[] args) {
        SitiosWebbd sw = new SitiosWebbd();
        System.out.println(sw.ObtenerSitiosWeb());
    }
}

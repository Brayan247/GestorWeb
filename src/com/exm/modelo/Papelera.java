/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exm.modelo;

import java.util.Date;

public class Papelera {

    public int idpapelera;
    public String nombre, url;
    public Date fecha_registro;
    public int seguridad;
    public Date fecha_ultimo_acceso;
    public Date fecha_actualizacion;

    public Papelera() {
    }

    public int getIdpapelera() {
        return idpapelera;
    }

    public void setIdpapelera(int idpapelera) {
        this.idpapelera = idpapelera;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
        this.seguridad = seguridad;
    }

    public Date getFecha_ultimo_acceso() {
        return fecha_ultimo_acceso;
    }

    public void setFecha_ultimo_acceso(Date fecha_ultimo_acceso) {
        this.fecha_ultimo_acceso = fecha_ultimo_acceso;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    @Override
    public String toString() {
        return "Papelera{" + "idpapelera=" + idpapelera + ", nombre=" + nombre + ", url=" + url + ", fecha_registro=" + fecha_registro + ", seguridad=" + seguridad + ", fecha_ultimo_acceso=" + fecha_ultimo_acceso + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }
    
}


package com.exm.modelo;

import java.util.Date;

public class SitiosWeb {
    
    public int idsitiosweb;
    public String nombre, url;
    public Date fecha_registro;
    public int seguridad;
    public Date fecha_ultimo_acceso;
    public Date fecha_actualizacion;

    public SitiosWeb() {
    }

    public int getIdsitiosweb() {
        return idsitiosweb;
    }

    public void setIdsitiosweb(int idsitiosweb) {
        this.idsitiosweb = idsitiosweb;
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
        return "SitiosWeb{" + "idsitiosweb=" + idsitiosweb + ", nombre=" + nombre + ", url=" + url + ", fecha_registro=" + fecha_registro + ", seguridad=" + seguridad + ", fecha_ultimo_acceso=" + fecha_ultimo_acceso + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }


    
}

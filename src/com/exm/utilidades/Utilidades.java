/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exm.utilidades;

import java.awt.Desktop;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public String devolverFecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);
    }


    public boolean urlValidator(String url) {
    try {
        new URL(url).toURI();
    } catch (MalformedURLException | URISyntaxException e) {
        System.out.println("Url Invalido");
        return false;
    }
    System.out.println("Url Valido");
    return true;
    }

    public void abirenlace(String enlaceAAceder) {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI(enlaceAAceder));
        } catch (IOException | URISyntaxException e) {
            e.getMessage();
        }
    }
    
    public int seguridadurl(String url){
        String dato = url.substring(0, 5);
        System.out.println(dato);
        if(dato.equals("https")){
            System.out.println("Es seguro");
            return 1;
        }else{
            System.out.println("no es seguro");
            return 2;
        }
    }


    public static void main(String[] args){
        String url = "http://www.manualweb.net/java/funciones-basicas-con-cadenas/";
        Utilidades ut = new Utilidades();
//        ut.urlValidator(url);
        ut.seguridadurl(url);
    }

}

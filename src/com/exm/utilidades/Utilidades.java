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

    public int urlSeguridad(String url) {
        /*validación de url*/
        try {
            new URL(url).toURI();
            System.out.println("URL Seguro");
            return 1;
        } catch (URISyntaxException exception) {
            System.out.println("URL No es Seguro");
            return 2;
        } catch (MalformedURLException exception) {
            System.out.println("No es un url");
            return 0;
        }
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


    public static void main(String[] args){
        String url = "https://www.google.com/search?q=verificar+si+un+link+existe+en+java&oq=verificar&aqs=chrome.0.69i59j69i57j69i59j0i433j0l3j69i61.6315j1j7&sourceid=chrome&ie=UTF-8";
        Utilidades ut = new Utilidades();
        ut.urlValidator(url);
    }

}

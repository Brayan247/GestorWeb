/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exm.modelTables;

import com.exm.modelo.SitiosWeb;
import com.exm.vistas.GestorSitiosWeb;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTableSitiosWeb extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"NOMBRE", "URL", "FECHA REGISTRO", "SEGURIDAD", "FECHA ULTIMO ACCESO", "FECHA ACTUALIZACION"};

    public List<SitiosWeb> sitios;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestorSitiosWeb gestionContable;
    public ModelTableSitiosWeb(List<SitiosWeb> sitiosweb,GestorSitiosWeb gestorweb) {
        this.sitios = sitiosweb;
        this.gestionContable = gestorweb;
    }

    @Override
    public int getRowCount() {
        return sitios.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SitiosWeb sweb = sitios.get(rowIndex);
        switch (columnIndex){
            case 0:
                return sweb.getNombre();
            case 1:
                return sweb.getUrl();
            case 2:
                return sweb.getFecha_registro();
            case 3:
                if(sweb.getSeguridad()==1){
                    return "Es Seguro";
                }else{
                    return "No es seguro";
                }
            case 4:
                return sweb.getFecha_ultimo_acceso();
            case 5:
                return sweb.getFecha_actualizacion();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}
     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex){
        gestionContable.clickSitiosWeb(sitios.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
     }

    public List<SitiosWeb> getInventario() {
        return sitios;
    }

    public void setInventario(List<SitiosWeb> inventario) {
        this.sitios = inventario;
    }



     
}


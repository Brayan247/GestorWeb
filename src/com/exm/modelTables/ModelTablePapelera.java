/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exm.modelTables;

import com.exm.modelo.Papelera;
import com.exm.vistas.GestorSitiosWeb;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ordenador
 */
public class ModelTablePapelera extends AbstractTableModel {
        //Arreglo con el nombre de las columnas
     public String[] m_colNames = {"NOMBRE", "URL", "FECHA REGISTRO", "SEGURIDAD", "FECHA ULTIMO ACCESO", "FECHA ACTUALIZACION"};

    public List<Papelera> papelera;

    private ComunicacionVistaModelosTablas comunicacionPersona;
    private GestorSitiosWeb gestionContable;
    public ModelTablePapelera(List<Papelera> inventario,GestorSitiosWeb gestionContable) {
        this.papelera = inventario;
        this.gestionContable = gestionContable;
    }

    @Override
    public int getRowCount() {
        return papelera.size();
    }

    @Override
    public int getColumnCount() {
       return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Papelera pplera = papelera.get(rowIndex);
        switch (columnIndex){
            case 0:
                return pplera.getNombre();
            case 1:
                return pplera.getUrl();
            case 2:
                return pplera.getFecha_registro();
            case 3:
                if(pplera.getSeguridad()==1){
                    return "Es Seguro";
                }else{
                    return "No es seguro";
                }
            case 4:
                return pplera.getFecha_ultimo_acceso();
            case 5:
                return pplera.getFecha_actualizacion();
        }
        return new String();
    }
     @Override
     public String getColumnName(int column){
    return m_colNames[column];
}
     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex){
        gestionContable.clickPapelera(papelera.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
     }

    public List<Papelera> getPapelera() {
        return papelera;
    }

    public void setPapelera(List<Papelera> papelera) {
        this.papelera = papelera;
    }



     
}


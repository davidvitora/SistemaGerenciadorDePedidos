/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import javax.swing.table.AbstractTableModel;
import restaurante.modelos.listas.MenuList;
import restaurante.entidades.ItemDoMenu;

/**
 *
 * @author David .V
 */
public class ModeloTabelaItemDeMenu extends AbstractTableModel implements Runnable{
    private String[] nomeColunas = {"id","Pratos", "Tempo de preparo", "Preço"};
    private MenuList listaMenu;
    private double tempoDePreparo;
    // construtor padrão criando um arraylist de alunos
    public ModeloTabelaItemDeMenu(){
        this.listaMenu = new MenuList();
    }
    // construtor que adiciona a lista passada pelo método ao alunos
    public ModeloTabelaItemDeMenu(MenuList listaMenu){
        this.listaMenu = listaMenu;
        super.fireTableDataChanged();
    }
    
    public void updateTable(){
        super.fireTableDataChanged();
    }
    
    public int getRowCount() {
        return listaMenu.size();
    }
    public int getColumnCount() {
        return nomeColunas.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
                 ItemDoMenu item = (ItemDoMenu) listaMenu.get( rowIndex );
         switch( columnIndex ) {
             case 0: return item.getId();
             case 1: return item.getNome();
             case 2: if((item.getTempoDePreparo()/60) <10 && item.getTempoDePreparo()%60 >=10){
                        return ("0"+item.getTempoDePreparo()/60) +":"+ Math.abs((item.getTempoDePreparo()%60));
                    } 
                     else if(item.getTempoDePreparo()/60 <10 && item.getTempoDePreparo()%60 <10){
                        return ("0"+item.getTempoDePreparo()/60) +":0"+ Math.abs((item.getTempoDePreparo()%60));
                    }
                     else if((item.getTempoDePreparo()%60) <10 && item.getTempoDePreparo()/60 >=10){
                        return (item.getTempoDePreparo()/60) +":0"+ Math.abs((item.getTempoDePreparo()%60));
                    }
                     return (item.getTempoDePreparo()/60) +":"+ Math.abs((item.getTempoDePreparo()%60));
             case 3: return item.getPreco();
             case 4: return item.getTempoDePreparo();
         }
         return null;
    }

    @Override
    public void run() {
        updateTable();
    }
}

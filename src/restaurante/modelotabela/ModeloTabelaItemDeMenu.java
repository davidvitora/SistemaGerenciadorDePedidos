/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import javax.swing.table.AbstractTableModel;
import restaurante.modelos.listas.MenuList;
import restaurante.modelos.listas.PedidosEsperandoList;
import restaurante.entidades.ItemDoMenu;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class ModeloTabelaItemDeMenu extends AbstractTableModel implements Runnable{
    private String[] nomeColunas = {"id","Pratos", "Tempo de preparo", "Preço"};
    private MenuList listaMenu;
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
             case 2: return item.getPreco();
             case 3: return item.getTempoDePreparo();
         }
         return null;
    }

    @Override
    public void run() {
        updateTable();
    }
}

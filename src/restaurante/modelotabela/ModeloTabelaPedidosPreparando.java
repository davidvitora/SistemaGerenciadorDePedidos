/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import javax.swing.table.AbstractTableModel;
import restaurante.controladores.MenuList;
import restaurante.controladores.PedidosList;
import restaurante.controladores.PreparoList;
import restaurante.entidades.Cozinheiro;
import restaurante.entidades.ItemDoMenu;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class ModeloTabelaPedidosPreparando extends AbstractTableModel implements Runnable{
    private String[] nomeColunas = {"Cozinheiro", "Pedido", "Tempo"};
    private PreparoList preparoList;
    // construtor padrão criando um arraylist de alunos
    
    // construtor que adiciona a lista passada e informa ao modelo que houve mudança
    public ModeloTabelaPedidosPreparando(PreparoList preparoList){
        this.preparoList = preparoList;
        super.fireTableDataChanged();
    }
    
    public void updateTable(){
        super.fireTableDataChanged();
    }
    
    public int getRowCount() {
        return preparoList.getListaDeCozinheiros().size();
    }
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Cozinheiro item = (Cozinheiro) preparoList.getListaDeCozinheiros().get( rowIndex );
         switch( columnIndex ) {
             case 0: return item.getNome();
             case 1: return item.getPedidoPreparando().getNome();
             case 2: return item.getPedidoPreparando().getTempoMaximoDeEspera();
         }
         return null;
    }

    @Override
    public void run() {
        updateTable();
    }
}

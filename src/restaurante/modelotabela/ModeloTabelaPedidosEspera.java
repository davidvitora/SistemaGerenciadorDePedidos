/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import restaurante.controladores.PedidosList;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class ModeloTabelaPedidosEspera extends AbstractTableModel implements Runnable{

    private String[] nomeColunas = {"Pratos", "Tempo"};
    private PedidosList pedidos;
    // construtor padrão criando um arraylist de alunos
    public ModeloTabelaPedidosEspera(){
        this.pedidos = new PedidosList();
    }
    // construtor que adiciona a lista passada pelo método ao alunos
    public ModeloTabelaPedidosEspera(PedidosList pedidos){
        this.pedidos = pedidos;
        super.fireTableDataChanged();
    }
    
    public void updateTable(){
        super.fireTableDataChanged();
    }
    
    public int getRowCount() {
        return pedidos.size();
    }
    public int getColumnCount() {
        return nomeColunas.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Pedido pedido = (Pedido) pedidos.get( rowIndex );
         switch( columnIndex ) {
             case 0: return pedido.getNome();
             case 1: return pedido.getTempoMaximoDeEspera();
         }
         return null;
    }

    @Override
    public void run() {
        updateTable();
    }
}

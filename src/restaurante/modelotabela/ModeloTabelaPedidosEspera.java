/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelotabela;

import javax.swing.table.AbstractTableModel;
import restaurante.modelos.listas.PedidosEsperandoList;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class ModeloTabelaPedidosEspera extends AbstractTableModel implements Runnable{
    
    private String[] nomeColunas = {"Pratos", "Tempo"};
    private PedidosEsperandoList pedidos;
    // construtor padrão criando um arraylist de alunos
    public ModeloTabelaPedidosEspera(){
        this.pedidos = new PedidosEsperandoList();
    }
    // construtor que adiciona a lista passada pelo método ao alunos
    public ModeloTabelaPedidosEspera(PedidosEsperandoList pedidos){
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
             case 1:
                    if(pedido.getTempoMaximoDeEspera()%60 ==0 && pedido.getTempoMaximoDeEspera()/60 == 0){
                        return "00:00";
                    }
                    if(pedido.getTempoMaximoDeEspera()%60 <=0 && pedido.getTempoMaximoDeEspera()/60 <= 0){    
                        if(pedido.getTempoMaximoDeEspera()/60 >-10 && pedido.getTempoMaximoDeEspera()%60 <=-10){
                             return ("-0"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                         }
                         else if(pedido.getTempoMaximoDeEspera()/60 >-10 && pedido.getTempoMaximoDeEspera()%60> -10){
                             return ("-0"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":0" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                         }
                         else if(pedido.getTempoMaximoDeEspera()%60 >-10 && pedido.getTempoMaximoDeEspera()/60 <=-10){
                             return ("-"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":0" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                         }
                         else if(pedido.getTempoMaximoDeEspera()%60 <=-10 && pedido.getTempoMaximoDeEspera()/60 <=-10)
                         return ("-"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                        }
                    
                    
                    
                     if(pedido.getTempoMaximoDeEspera()/60 <10 && pedido.getTempoMaximoDeEspera()%60 >=10){
                         return ("0"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                     }
                     else if(pedido.getTempoMaximoDeEspera()/60 <10 && pedido.getTempoMaximoDeEspera()%60 <10){
                         return ("0"+Math.abs(pedido.getTempoMaximoDeEspera()/60)) + ":0" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                     }
                     else if(pedido.getTempoMaximoDeEspera()%60 <10 && pedido.getTempoMaximoDeEspera()/60 >=10){
                         return (pedido.getTempoMaximoDeEspera()/60) + ":0" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                     }
                     return (pedido.getTempoMaximoDeEspera()/60) + ":" + Math.abs(pedido.getTempoMaximoDeEspera()%60);
                     
                     
                     
         }
         return null;
    }

    @Override
    public void run() {
        updateTable();
    }
}

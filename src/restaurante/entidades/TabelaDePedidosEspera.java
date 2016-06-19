/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.List;
import restaurante.modelos.listas.PedidosEsperandoList;
import restaurante.modelotabela.ModeloTabelaPedidosEspera;

/**
 *
 * @author David .V
 */
public class  TabelaDePedidosEspera implements Runnable{
    List<Pedido> pedidos = new PedidosEsperandoList();
    private javax.swing.table.TableModel modeloTabela = new ModeloTabelaPedidosEspera(getListadePedidos());
    Thread thpedidos = new Thread((Runnable) pedidos);
    Thread thmodelo = new Thread((Runnable) modeloTabela);
    
    public TabelaDePedidosEspera(){      
    }

    
    public PedidosEsperandoList getListadePedidos(){
        return (PedidosEsperandoList)pedidos;
    }
    
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    @Override
    public void run() {
        thpedidos.run();
        thmodelo.run();
    }

    /**
     * @return the modeloTabela
     */
    public javax.swing.table.TableModel getModeloTabela() {
        return modeloTabela;
    }

    /**
     * @param modeloTabela the modeloTabela to set
     */
    public void setModeloTabela(javax.swing.table.TableModel modeloTabela) {
        this.modeloTabela = modeloTabela;
    }
}

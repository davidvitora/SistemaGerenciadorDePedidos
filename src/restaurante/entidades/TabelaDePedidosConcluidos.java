/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import restaurante.modelos.listas.PedidosConcluidosList;
import restaurante.modelotabela.ModeloTabelaPedidosConcluidos;

/**
 *
 * @author David .V
 */
public class TabelaDePedidosConcluidos{
    private ModeloTabelaPedidosConcluidos modeloTabela;
    private PedidosConcluidosList pedidosConcluidos;
    
    public TabelaDePedidosConcluidos(){
        this.pedidosConcluidos = new PedidosConcluidosList();
        this.modeloTabela = new ModeloTabelaPedidosConcluidos(getPedidosConcluidos());
    }
   
    public void atualizaTabela(){
        modeloTabela.run();
    }

    /**
     * @return the modeloTabela
     */
    public ModeloTabelaPedidosConcluidos getModeloTabela() {
        return modeloTabela;
    }

    /**
     * @param modeloTabela the modeloTabela to set
     */
    public void setModeloTabela(ModeloTabelaPedidosConcluidos modeloTabela) {
        this.modeloTabela = modeloTabela;
    }

    /**
     * @return the pedidosConcluidos
     */
    public PedidosConcluidosList getPedidosConcluidos() {
        return pedidosConcluidos;
    }

    /**
     * @param pedidosConcluidos the pedidosConcluidos to set
     */
    public void setPedidosConcluidos(PedidosConcluidosList pedidosConcluidos) {
        this.pedidosConcluidos = pedidosConcluidos;
    }
}

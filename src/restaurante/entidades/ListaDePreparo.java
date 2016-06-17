/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.controladores.PedidosList;
import restaurante.controladores.PreparoList;
import restaurante.modelotabela.ModeloTabelaPedidosPreparando;

/**
 *
 * @author David .V
 */
public class ListaDePreparo{
    public PreparoList listaDePreparo;
    private javax.swing.table.TableModel modeloTabela;
    Thread thModeloTabela;
    
    public ListaDePreparo(List pedidos){
        this.listaDePreparo = new  PreparoList((PedidosList) pedidos);
        this.modeloTabela = new ModeloTabelaPedidosPreparando(getListaDePreparo());
        this.thModeloTabela = new Thread((Runnable) getModeloTabela());
    }
    
    public void verificarListaDePreparo(){
        listaDePreparo.controleDeCozinheiros();
        thModeloTabela.run();
    }

    /**
     * @return the listaDePreparo
     */
    public PreparoList getListaDePreparo() {
        return listaDePreparo;
    }

    /**
     * @param listaDePreparo the listaDePreparo to set
     */
    public void setListaDePreparo(PreparoList listaDePreparo) {
        this.listaDePreparo = listaDePreparo;
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

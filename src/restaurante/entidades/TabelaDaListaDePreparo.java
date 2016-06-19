/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.modelos.listas.PedidosConcluidosList;
import restaurante.modelos.listas.PedidosEsperandoList;
import restaurante.modelos.listas.PreparoList;
import restaurante.modelotabela.ModeloTabelaPedidosPreparando;

/**
 *
 * @author David .V
 */
public class TabelaDaListaDePreparo{
    public PreparoList listaDePreparo;
    private ModeloTabelaPedidosPreparando modeloTabela;
    Thread thModeloTabela;
    Thread thControleDeCozinheiros;
    
    public TabelaDaListaDePreparo(List pedidos, PedidosConcluidosList pedidosConcluidos){
        this.listaDePreparo = new  PreparoList((PedidosEsperandoList) pedidos, pedidosConcluidos);
        this.modeloTabela = new ModeloTabelaPedidosPreparando(getListaDePreparo());
        this.thModeloTabela = new Thread((Runnable) getModeloTabela());
        thControleDeCozinheiros = new Thread((Runnable) getListaDePreparo());
    }
    
    public void verificarListaDePreparo(){
        try{
            /* Realiza função para definir pedidos para cozinheiros ociosos e verificar se algum terminou*/
            thControleDeCozinheiros.run();
            System.out.println("Controle de cozinheiros realizado");
        }catch(Exception e){
            e.getStackTrace();
        }
        modeloTabela.updateTable();
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
        this.modeloTabela = (ModeloTabelaPedidosPreparando) modeloTabela;
    }
    
    
    
}

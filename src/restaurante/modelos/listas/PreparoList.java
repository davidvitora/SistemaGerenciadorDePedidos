/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelos.listas;

import java.util.ArrayList;
import restaurante.entidades.Cozinheiro;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PreparoList extends ArrayList implements Runnable{
    /* Referencias das listas de pedidos esperando e pedidos prontos */
    PedidosEsperandoList pedidos;
    PedidosConcluidosList pedidosConcluidos;
    Cozinheiro aux;
    /* Decarando cozinheiros */
    public static Cozinheiro coum = new Cozinheiro(1, "Paulo", true);
    public static Cozinheiro codois = new Cozinheiro(2, "Pedro", true);
    public static Cozinheiro cotres = new Cozinheiro(3, "João", true);
    public static Cozinheiro coquatro = new Cozinheiro(4, "Chef Pepino", true);
    
    public PreparoList(PedidosEsperandoList pedidos, PedidosConcluidosList pedidosConcluidos){
        this.pedidos = pedidos;
        this.pedidosConcluidos = pedidosConcluidos;
        this.add(coum);
        this.add(codois);
        this.add(cotres);
        this.add(coquatro);
        
    }
    
    public void controleDeCozinheiros(){
        /* Realizará o controle de cada cozinheiro da lista */
        for (Object cozinheiro : this) {
            aux = (Cozinheiro) cozinheiro;
            aux.getPedidoPreparando().setTempoMaximoDePreparo((aux.getPedidoPreparando().getTempoMaximoDePreparo()) - 1);
            /* Caso o pedido esteja com tempo 0, será enviado para a lista de concluidos e o cozinheiro ficara livre */
            if(aux.getPedidoPreparando().getTempoMaximoDePreparo() <= 0 && aux.isLivre() == false && aux.getPedidoPreparando() != aux.PLivre){
                pedidosConcluidos.addPedidoConcluido(aux.getPedidoPreparando());
                aux.setLivre(true);
            }
            /* Se o cozinheiro estiver livre e tiver itens da lista de pedidos esperando, o primeiro item da lista de pedidos será designado para ele e removido da lista de pedidos esperando */
            if(aux.isLivre() && pedidos.isEmpty() == false){
                aux.setPedidoPreparando((Pedido) pedidos.get(0));
                pedidos.remove(0);
                aux.setLivre(false);
            }
        }
    }

    @Override
    public void run() {
        controleDeCozinheiros();
    }

}

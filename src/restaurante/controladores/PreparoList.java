/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import java.util.List;
import restaurante.entidades.Cozinheiro;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PreparoList extends ArrayList implements Runnable{
    PedidosList pedidos;
    Cozinheiro aux;
    public static final Cozinheiro coum = new Cozinheiro(1, "Paulo", true);
    public static Cozinheiro codois = new Cozinheiro(2, "Pedro", true);
    public static Cozinheiro cotres = new Cozinheiro(3, "João", true);
    public static Cozinheiro coquatro = new Cozinheiro(4, "Chef Pepino", true);
    
    public PreparoList(PedidosList pedidos){
        this.pedidos = pedidos;
        this.add(coum);
        this.add(codois);
        this.add(cotres);
        this.add(coquatro);
        
    }
    
    public void controleDeCozinheiros(){
        for(int i = 0; i < this.size(); i++){
           aux = (Cozinheiro) this.get(i);
           aux.getPedidoPreparando().setTempoMaximoDePreparo((aux.getPedidoPreparando().getTempoMaximoDePreparo()) - 1);
           if(aux.getPedidoPreparando().getTempoMaximoDePreparo() <= 0 && aux.isLivre() == false && aux.getPedidoPreparando() != aux.PLivre){
               aux.setLivre(true);
           }
           if(aux.isLivre() && pedidos.isEmpty() == false){
               aux.setPedidoPreparando((Pedido) pedidos.get(0));
               System.out.println("Colocando o pedido " + pedidos.get(0).toString() + "Para o cozinheiro" + aux.getNome());
               pedidos.remove(0);
               aux.setLivre(false);
           }
            System.out.println("Cozinheiro" + aux.getNome() + "Preparando: " + aux.getPedidoPreparando().getNome() + "No tempo: " + aux.getPedidoPreparando().getTempoMaximoDePreparo() );
        }
    }

    @Override
    public void run() {
        controleDeCozinheiros();
    }

}

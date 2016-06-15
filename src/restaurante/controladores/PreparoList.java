/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import restaurante.entidades.Cozinheiro;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PreparoList implements Runnable{
    PedidosList pedidos;
    ArrayList cozinheiros = new ArrayList();
    Cozinheiro aux;
    Cozinheiro coum = new Cozinheiro(1, "Ratatouille", true);
    Cozinheiro codois = new Cozinheiro(1, "Ratatouille", true);
    Cozinheiro cotres = new Cozinheiro(1, "Ratatouille", true);
    Cozinheiro coquatro = new Cozinheiro(1, "Ratatouille", true);
    
    public PreparoList(PedidosList pedidos){
        cozinheiros.add(coum);
        cozinheiros.add(codois);
        cozinheiros.add(cotres);
        cozinheiros.add(coquatro);
        this.pedidos = pedidos;
    }
    
    public ArrayList getListaDeCozinheiros(){
        return cozinheiros;
    }
    
    @Override
    public void run() {
        
        for(int i = 0; i < cozinheiros.size(); i++){
           aux = (Cozinheiro) cozinheiros.get(i);
           aux.getPedidoPreparando().setTempoMaximoDePreparo(aux.getPedidoPreparando().getTempoMaximoDePreparo() -1);
           if(aux.getPedidoPreparando().getTempoMaximoDePreparo() == 0){
               aux.setLivre(true);
           }
        }
        for(int i = 0; i < cozinheiros.size(); i++){
           if(aux.isLivre()){
               aux.setPedidoPreparando((Pedido) pedidos.get(0));
               pedidos.remove(0);
           }
        }  
    }
    
}

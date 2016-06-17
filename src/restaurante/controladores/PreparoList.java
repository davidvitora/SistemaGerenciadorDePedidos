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
public class PreparoList{
    PedidosList pedidos;
    ArrayList cozinheiros = new ArrayList();
    Cozinheiro aux;
    Cozinheiro  coum;
    Cozinheiro codois;
    Cozinheiro cotres;
    Cozinheiro coquatro;
    
    public PreparoList(PedidosList pedidos){
        coum = new Cozinheiro(1, "Ratatouille", true);
        codois = new Cozinheiro(2, "Ratatouille", true);
        cotres = new Cozinheiro(3, "Ratatouille", true);
        coquatro = new Cozinheiro(4, "Ratatouille", true);
        cozinheiros.add(coum);
        cozinheiros.add(codois);
        cozinheiros.add(cotres);
        cozinheiros.add(coquatro);
        this.pedidos = pedidos;
    }
    
    public ArrayList getListaDeCozinheiros(){
        return cozinheiros;
    }
    
    public void controleDeCozinheiros(){
        for(int i = 0; i < cozinheiros.size(); i++){
           aux = (Cozinheiro) cozinheiros.get(i);
           aux.getPedidoPreparando().setTempoMaximoDePreparo(aux.getPedidoPreparando().getTempoMaximoDePreparo() -1);
           if(aux.getPedidoPreparando().getTempoMaximoDePreparo() == 0 && aux.isLivre() == false){
               aux.setLivre(true);
           }
           //if(aux.isLivre() && pedidos.isEmpty() == false){
            //   aux.setPedidoPreparando((Pedido) pedidos.get(0));
            //   pedidos.remove(0);
           //}
        }
    }
}

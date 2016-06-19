/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelos.listas;

import java.util.ArrayList;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PedidosConcluidosList extends ArrayList{
    public PedidosConcluidosList(){
        
    }
    
    public void addPedidoConcluido(Pedido pedido){
        pedido.setTempoTotal((System.currentTimeMillis() / 1000) - pedido.getTempoInicial());
        add(pedido);
    }
}

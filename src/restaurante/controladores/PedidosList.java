/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PedidosList extends ArrayList implements Runnable{
    
    public void atualizaTempoFilaDeEspera(){
        Pedido pedido;
        for(int i = 0; i < size(); i++){
            pedido = (Pedido) get(i);
            pedido.setTempoEsperando((System.currentTimeMillis() / 1000) - pedido.getTempoInicial());
            if(pedido.getTempoEsperando() > pedido.getTempoMaximoDeEspera()){
                pedido.setAtrazado(true);
            }
        }
    }

    @Override
    public void run() {
        atualizaTempoFilaDeEspera();
    }

}

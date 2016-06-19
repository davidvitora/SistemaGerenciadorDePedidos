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
public class PedidosEsperandoList extends ArrayList implements Runnable{
    
    public void atualizaTempoFilaDeEspera(){
        Pedido pedido;
        for(int i = 0; i < size(); i++){
            pedido = (Pedido) get(i);
            pedido.setTempoMaximoDeEspera(pedido.getTempoMaximoDeEspera() - 1);
        }
    }

    @Override
    public void run() {
        atualizaTempoFilaDeEspera();
    }

}

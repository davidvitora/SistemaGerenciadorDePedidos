/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controladores;

import java.util.ArrayList;
import restaurante.entidades.ItemDoMenu;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class PedidosList extends ArrayList implements Runnable{
    private long seconds = 0;
    public ItemDoMenu prato;
    
    
    public long setTime(){
        return seconds-1;
    }
    
    public void atualizaTempoFilaDeEspera(){
        Pedido pedido;
        for (Object my : this) {
            pedido = (Pedido) my;
            if(seconds==0){
                seconds = 59;
                pedido.setTempoMaximoDeEspera((long) (prato.getTempoDePreparo()/2), seconds);
            }
            else{
             pedido.setTempoMaximoDeEspera((long) (prato.getTempoDePreparo()/2) - 1,setTime());
            }
            if(pedido.getTempoEsperando() <= 0 ){
                pedido.setAtrazado(true);
            }
        }
    }

    @Override
    public void run() {
        atualizaTempoFilaDeEspera();
    }

}

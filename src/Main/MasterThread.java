/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.entidades.TabelaDeItensDoMenu;
import restaurante.entidades.TabelaDePedidosEspera;
import restaurante.entidades.TabelaDaListaDePreparo;
import restaurante.entidades.TabelaDePedidosConcluidos;

/**
 *
 * @author David .V
 */
public final class MasterThread implements Runnable{
    private TabelaDePedidosEspera lP;
    private TabelaDeItensDoMenu lI;
    private TabelaDaListaDePreparo listaDePreparo;
    private final Thread THListaDePedidosEspera;
    private TabelaDePedidosConcluidos tabelaDePedidosConcluidos;
    
    public MasterThread(){
        this.lP = new TabelaDePedidosEspera();
        THListaDePedidosEspera = new Thread(getlP());
        this.tabelaDePedidosConcluidos = new TabelaDePedidosConcluidos();
        this.listaDePreparo = new TabelaDaListaDePreparo((List)getlP().getListadePedidos(), getTabelaDePedidosConcluidos().getPedidosConcluidos());
        this.lI = new TabelaDeItensDoMenu();
        
    }

    
    @Override
    public void run() {
        while(true){
            try {
                THListaDePedidosEspera.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MasterThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            getListaDePreparo().verificarListaDePreparo();
            THListaDePedidosEspera.run();
            getTabelaDePedidosConcluidos().atualizaTabela();
        }  
    }

    /**
     * @return the lP
     */
    public TabelaDePedidosEspera getlP() {
        return lP;
    }

    /**
     * @param lP the lP to set
     */
    public void setlP(TabelaDePedidosEspera lP) {
        this.lP = lP;
    }

    /**
     * @return the lI
     */
    public TabelaDeItensDoMenu getlI() {
        return lI;
    }

    /**
     * @param lI the lI to set
     */
    public void setlI(TabelaDeItensDoMenu lI) {
        this.lI = lI;
    }

    /**
     * @return the listaDePreparo
     */
    public TabelaDaListaDePreparo getListaDePreparo() {
        return listaDePreparo;
    }

    /**
     * @param listaDePreparo the listaDePreparo to set
     */
    public void setListaDePreparo(TabelaDaListaDePreparo listaDePreparo) {
        this.listaDePreparo = listaDePreparo;
    }

    /**
     * @return the tabelaDePedidosConcluidos
     */
    public TabelaDePedidosConcluidos getTabelaDePedidosConcluidos() {
        return tabelaDePedidosConcluidos;
    }

    /**
     * @param tabelaDePedidosConcluidos the tabelaDePedidosConcluidos to set
     */
    public void setTabelaDePedidosConcluidos(TabelaDePedidosConcluidos tabelaDePedidosConcluidos) {
        this.tabelaDePedidosConcluidos = tabelaDePedidosConcluidos;
    }
    
}

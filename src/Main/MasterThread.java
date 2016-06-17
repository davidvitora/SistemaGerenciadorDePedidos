/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.entidades.ListaDeItemDoMenu;
import restaurante.entidades.ListaDePedidosEspera;
import restaurante.entidades.ListaDePreparo;

/**
 *
 * @author David .V
 */
public final class MasterThread implements Runnable{
    private ListaDePedidosEspera lP;
    private ListaDeItemDoMenu lI;
    private ListaDePreparo listaDePreparo;
    private final Thread THListaDePedidosEspera;
    
    public MasterThread(){
        this.lP = new ListaDePedidosEspera();
        THListaDePedidosEspera = new Thread(getlP());
        this.listaDePreparo = new ListaDePreparo((List)getlP().getListadePedidos());
        this.lI = new ListaDeItemDoMenu();
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
            
        }  
    }

    /**
     * @return the lP
     */
    public ListaDePedidosEspera getlP() {
        return lP;
    }

    /**
     * @param lP the lP to set
     */
    public void setlP(ListaDePedidosEspera lP) {
        this.lP = lP;
    }

    /**
     * @return the lI
     */
    public ListaDeItemDoMenu getlI() {
        return lI;
    }

    /**
     * @param lI the lI to set
     */
    public void setlI(ListaDeItemDoMenu lI) {
        this.lI = lI;
    }

    /**
     * @return the listaDePreparo
     */
    public ListaDePreparo getListaDePreparo() {
        return listaDePreparo;
    }

    /**
     * @param listaDePreparo the listaDePreparo to set
     */
    public void setListaDePreparo(ListaDePreparo listaDePreparo) {
        this.listaDePreparo = listaDePreparo;
    }
    
}

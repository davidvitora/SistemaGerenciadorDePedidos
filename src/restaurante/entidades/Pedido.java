/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David .V
 */
public class Pedido{
    private int id;
    public ItemDoMenu prato;
    private String nome;
    private long tempoInicial;
    private long tempoMaximoDeEspera;
    private long tempoMaximoDePreparo;
    private long tempoTotal;
    
    public Pedido(ItemDoMenu prato){
        this.prato = prato;
        this.nome = prato.getNome();
        tempoInicial = System.currentTimeMillis() / 1000;
        tempoMaximoDeEspera = calcularTempoMaximoDeEspera(prato.getTempoDePreparo());
        tempoMaximoDePreparo = (long) prato.getTempoDePreparo();
        this.tempoTotal = 0;
    }
    
    public long calcularTempoMaximoDeEspera(double tempoDePreparo){
        return (long) (tempoDePreparo / 2);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the tempoInicial
     */
    public long getTempoInicial() {
        return tempoInicial;
    }

    /**
     * @param tempoInicial the tempoInicial to set
     */
    public void setTempoInicial(long tempoInicial) {
        this.tempoInicial = tempoInicial;
    }

    /**
     * @return the tempoMaximoDeEspera
     */
    public long getTempoMaximoDeEspera() {
        return tempoMaximoDeEspera;
    }

    /**
     * @param tempoMaximoDeEspera the tempoMaximoDeEspera to set
     */
    public void setTempoMaximoDeEspera(long tempoMaximoDeEspera) {
        this.tempoMaximoDeEspera = tempoMaximoDeEspera;
    }

    /**
     * @return the tempoMaximoDePreparo
     */
    public long getTempoMaximoDePreparo() {
        return tempoMaximoDePreparo;
    }

    /**
     * @param tempoMaximoDePreparo the tempoMaximoDePreparo to set
     */
    public void setTempoMaximoDePreparo(long tempoMaximoDePreparo) {
        this.tempoMaximoDePreparo = tempoMaximoDePreparo;
    }

    /**
     * @return the tempoTotal
     */
    public long getTempoTotal() {
        return tempoTotal;
    }

    /**
     * @param tempoTotal the tempoTotal to set
     */
    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
   
}

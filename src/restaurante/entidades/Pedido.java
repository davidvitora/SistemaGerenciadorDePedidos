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
    private long tempoEsperando;
    private long tempoMaximoDeEspera;
    private long tempoMaximoDePreparo;
    private boolean Atrazado;
    
    public Pedido(ItemDoMenu prato){
        this.prato = prato;
        this.nome = prato.getNome();
        tempoInicial = System.currentTimeMillis() / 1000;
        tempoEsperando = 0;
        Atrazado = false;
        tempoMaximoDeEspera = calcularTempoMaximoDeEspera(prato.getTempoDePreparo());
        tempoMaximoDePreparo = (long) prato.getTempoDePreparo();
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
     * @return the tempoEsperando
     */
    public long getTempoEsperando() {
        return tempoEsperando;
    }

    /**
     * @param tempoEsperando the tempoEsperando to set
     */
    public void setTempoEsperando(long tempoEsperando) {
        this.tempoEsperando = tempoEsperando;
    }

    /**
     * @return the Atrazado
     */
    public boolean isAtrazado() {
        return Atrazado;
    }

    /**
     * @param Atrazado the Atrazado to set
     */
    public void setAtrazado(boolean Atrazado) {
        this.Atrazado = Atrazado;
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
   
}

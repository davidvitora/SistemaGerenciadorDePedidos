/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.ArrayList;

/**
 *
 * @author David .V
 */
public class Cozinheiro extends ArrayList{
    private int id;
    private String nome;
    private Pedido pedidoPreparando;
    private boolean livre;
    private final ItemDoMenu itemDoMenu;
    public final Pedido PLivre;
    
    public Cozinheiro(int id, String nome, boolean livre){
        this.itemDoMenu = new ItemDoMenu(0, "Livre", 0.0 ,(long) 00);
        this.PLivre = new Pedido(itemDoMenu);
        this.id = id;
        this.nome = nome;
        this.pedidoPreparando = PLivre;
        this.livre = livre;
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
     * @return the pedidoPreparando
     */
    public Pedido getPedidoPreparando() {
        return pedidoPreparando;
    }

    /**
     * @param pedidoPreparando the pedidoPreparando to set
     */
    public void setPedidoPreparando(Pedido pedidoPreparando) {
        this.pedidoPreparando = pedidoPreparando;
    }
    

    /**
     * @return the livre
     */
    public boolean isLivre() {
        return livre;
    }

    /**
     * @param livre the livre to set
     */
    public void setLivre(boolean livre) {
        this.livre = livre;
        if(livre == true){
            this.pedidoPreparando = PLivre;
        }
    }
    
    
}

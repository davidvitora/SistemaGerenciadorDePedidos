/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

/**
 *
 * @author David .V
 */
public class ItemDoMenu {
    private int id;
    private String nome;
    private double preco;
    private double tempoDePreparo;
    
    public ItemDoMenu(int id, String nome, double preco, long tempoDePreparo){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tempoDePreparo = tempoDePreparo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @return the tempoDePreparo
     */
    public double getTempoDePreparo() {
        return tempoDePreparo;
    }
    
    
}
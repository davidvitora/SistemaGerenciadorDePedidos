/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelos.listas;

import java.util.ArrayList;
import restaurante.entidades.ItemDoMenu;
import restaurante.entidades.Pedido;

/**
 *
 * @author David .V
 */
public class MenuList extends ArrayList{
    
    
    public MenuList(){
        ItemDoMenu item = new ItemDoMenu(1, "Macarronada", 150, 150);
        this.add(item);
        item = new ItemDoMenu(2, "batata frita", 60, 60);
        this.add(item);
        item = new ItemDoMenu(3, "Arroz com feijão", 200, 200);
        this.add(item);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelos.listas;

import java.util.ArrayList;
import restaurante.entidades.ItemDoMenu;

/**
 *
 * @author David .V
 */
public class MenuList extends ArrayList{
    
    
    public MenuList(){
        ItemDoMenu item = new ItemDoMenu(1, "Macarronada", 8, 600);
        this.add(item);
        item = new ItemDoMenu(2, "Batata frita", 5, 300);
        this.add(item);
        item = new ItemDoMenu(3, "Arroz com feijão", 8, 900);
        this.add(item);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.controladores.MenuList;
import restaurante.modelotabela.ModeloTabelaItemDeMenu;
import restaurante.modelotabela.ModeloTabelaPedidosEspera;

/**
 *
 * @author David .V
 */
public class  ListaDeItemDoMenu{
    List<ItemDoMenu> menu = new MenuList();
    private javax.swing.table.TableModel modeloTabela = new ModeloTabelaItemDeMenu(getListaMenu());
    private javax.swing.JTable filaDeEsperaTabela;
    ItemDoMenu item = new ItemDoMenu(1, "Macarronada", 2.50, 30);
    Thread thmodelo = new Thread((Runnable) modeloTabela);
    
    public ListaDeItemDoMenu(){
        this.menu.add(item);      
    }
    
    public MenuList getListaMenu(){
        return (MenuList)menu;
    }

    /**
     * @return the modeloTabela
     */
    public javax.swing.table.TableModel getModeloTabela() {
        return modeloTabela;
    }
}

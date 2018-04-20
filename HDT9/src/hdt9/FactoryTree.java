/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;

/**
 *
 * @author JUMPSTONIK
 */
public class FactoryTree<E> {
    InterArboles newTree;
    
    public FactoryTree(){}
    
    public InterArboles getTree(String opcionUsuario) {
    // seleccion de la implementacion a utilizar:
        
        if(opcionUsuario.equals("Red-Black Tree"))
        {
            newTree =  new RedBlackTree<>();
        }else if(opcionUsuario.equals("Splay Tree"))
        {
            newTree = new SplayTree<>();
        }
        
        return newTree;      
   }
    
}

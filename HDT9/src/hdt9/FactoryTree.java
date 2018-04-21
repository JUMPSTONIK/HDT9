/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author JUMPSTONIK
 */
public class FactoryTree<E> {
    InterArboles newTree;
    
    public FactoryTree(){}
    
    /**
     * esta es la funcion encargada de la instanciacion del tipo de arbol
     * que el usuario quiere usar
     * @param opcionUsuario opcion elegida por el usuario
     * @return instancia del arbol
     */
    public InterArboles implementar(String opcionUsuario) {
        
        if(opcionUsuario.equals("Red Black Tree")){
            newTree =  new RedBlackTree<>();
        }
        else if(opcionUsuario.equals("Splay Tree")){
            newTree = new SplayTree<>();
        }
        return newTree;      
   }
    
}

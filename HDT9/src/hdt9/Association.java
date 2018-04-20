/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase del association
 *@author Josue(JUMPSTONIK) David Lopez 17081
 * @author Sergio Alejandro Gordillo 16387
 * fecha:19/03/2018
 */
public class Association<K,V> extends java.lang.Object implements java.util.Map.Entry<K,V> {
    protected K Key;
    protected V Value;
    public Association(K key, V value) {
        this.Key = key;
        this.Value = value;
    }

    
    
    @Override
    /**
     * aqui obtienes el key
     */
    public K getKey() {
        return this.Key;
        
    }

    @Override
    /**
     * aqui obtienes el valor
     */
    public V getValue() {
        return this.Value;
        
    }

    @Override
    /**
     * no hace nada
     */
    public V setValue(V value) {
        return null;
        
    }
    
}

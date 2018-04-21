/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;
import java.util.Map;
/**
 * Clase del association
 *@author Josue(JUMPSTONIK) David Lopez 17081
 * @author Sergio Alejandro Gordillo 16387
 * fecha:20/04/2018
 */
public class Association<K,V> implements java.util.Map.Entry<K,V> {
    protected K laKey;
    protected V elValue;
    
    public Association(K key, V value) {
        laKey = key;
        elValue = value;
    }
    public Association(K key)
    {
        this(key,null);
    }
    
    @Override
    /**
     * aqui obtienes el key
     */
    public K getKey() {
        return laKey;
        
    }

    @Override
    /**
     * aqui obtienes el valor
     */
    public V getValue() {
        return elValue;
        
    }

    @Override
    /**
     * no hace nada
     */
    public V setValue(V value) {
        return null;
        
    }
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
}

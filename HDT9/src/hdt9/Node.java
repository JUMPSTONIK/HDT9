/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;
/**
 *
 * @author JUMPSTONIK
 * @author Sergio Marchena
 */
public class Node<E> {
    Association<String,String> data;
    Node<E> parent;
    Node<E> left,right;
    boolean color;
    int tamano;
 
    public Node() {
        
    }
    public Node(String ing, String espa) {
        data = new Association<>(ing, espa);
        parent = null; 
        left = right = null;
    }
    public Association<String, String> getValue() {
        return data; 
    }
    public void setVal(String valor) {
        this.data.setValue(valor);
    }
    public Node(String ing, String espa, boolean color, int tamano) {
        data = new Association<>(ing, espa);
        parent = null; 
        left = right = null;
        this.tamano = tamano;
        this.color = color;
    }
    public String getKey(){
        return data.getKey(); //devuelve la palabra en ingles
    }
    public String getEspa(){
        return data.elValue;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public Node<E> getLeft()
    {
        return left;
    }   
    public void setRight(Node right){
        this.right = right;
    }
    public Node<E> getRight(){
        return right;
    }
    public String toString(){
       String linea = "\t("+ data.laKey + ", " + data.elValue + ")";
       return linea;
    }
    public void setParent(Node nuevoParent){
            parent = nuevoParent;
    }
    public Node<E> getParent(){
        return parent;
    }
}

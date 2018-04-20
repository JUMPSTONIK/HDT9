/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author JUMPSTONIK
 */
public class BinarySearchTree{
    
    public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
    /**
     * este es el metodo encargado de meter los valores dentro del arbol
     * @param valor associacion de la palabra en ingle/español que esten 
     * manadndo 
     */
    public void insert(Association valor){
		Node newNode = new Node(valor);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
                
                int val1 = String.valueOf(valor.getKey()).compareTo(String.valueOf(current.data.getKey()))*-1;
                int val2 = String.valueOf(current.data.getKey()).compareTo(String.valueOf(valor.getKey()))*-1;
		while(true){
			parent = current;
			if( val1 < val2){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
    /**
     * esta funcion se encarga de obtener la palabra a traducir
     * @param valor palabra en ingles a traducir
     * @return devuelve la traduccion o la misma palabra sino existe su 
     * traduccion
     */
    public String find(String valor){
                String dat = "*"+valor+"* ";
		Node current = root;
                System.out.println(valor);
                String str = new String("rall");
                
                System.out.println(String.valueOf(current.data.getKey()));
                while(current!=null){
                        int val1 = valor.compareTo(String.valueOf(str))*-1;
                        int val2 = String.valueOf(current.data.getKey()).compareTo(str);
                        System.out.println("***"+current.data.getKey());
			if(valor.equals(current.data.Key)){
                                System.out.println("44444");
                                dat = String.valueOf(current.data.getValue());
				break;
			}else 
                            if(val2>val1){
                                System.out.println("1111");
				current = current.left;
                                
                            }else{
				current = current.right;
                            }
		}
		return dat;
	}
    /**
     * despliega el arbol
     * @param root nodo a mostrar
     */
    public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data.Key + ": " + root.data.Value);
			display(root.right);
		}
	}
    
    
}

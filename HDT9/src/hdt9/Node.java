/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUMPSTONIK
 */
public class Node<E> {
    Association<String,String> data;
    Node<E> left;
    Node<E> right;
 
    Node(Association value) {
        this.data = value;
        right = null;
        left = null;
    }
    

}

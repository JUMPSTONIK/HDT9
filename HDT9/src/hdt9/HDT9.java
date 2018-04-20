/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * este es el programa con la traduccion dela oracion dada
 * @author Josue(JUMPSTONIK) David Lopez 17081
 * @author Sergio Alejandro Gordillo 16387
 * fecha:19/03/2018
 */
public class HDT9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        String[] palabrasOracion;
        ArrayList<String> listaLineas = new ArrayList<String>();
        String traduccion = "";
        String linea = "";
        
        File file = new File("oracion.txt");
        
        
        //aqui se hace el intento por obtener el archivo con sus informaicon    
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //aqui esta extrayendos linea por linea del txt
            linea = br.readLine();

            fr.close();
        }//esto en caso halla algun error con el archivo
        catch(Exception e) {
            System.out.println("Excepcion leyendo fichero : " + e);
        }
        
        palabrasOracion = linea.split(">");
        
        
        
        file = new File("diccionario.txt");
        
        
        
        //aqui se hace el intento por obtener el archivo con sus informaicon    
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //aqui esta extrayendos linea por linea del txt
            while((linea = br.readLine()) != null){
                String[] diccionario = linea.split(">");
                listaLineas.add(diccionario[0]);
                listaLineas.add(diccionario[1]);
            fr.close();
        }
        }//esto en caso halla algun error con el archivo
        catch(Exception e) {
            System.out.println("Excepcion leyendo fichero : " + e);
        }
        
        
        
        System.out.println(linea);
        
        for (int i = 0; i < listaLineas.size()-1; i=i+2) {
            bst.insert(new Association<String,String>(listaLineas.get(i), listaLineas.get(i+1)));
            System.out.println("////");
        }
        
       bst.display(bst.root);
        System.out.println("");
        
        for (int i = 0; i < palabrasOracion.length; i++) {
            traduccion = traduccion + bst.find(palabrasOracion[i]);
        }
        
        System.out.println(traduccion);
        
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * este es el programa con la traduccion dela oracion dada
 * @author Josue(JUMPSTONIK) David Lopez 17081
 * @author Sergio Alejandro Gordillo 16387
 * fecha:19/03/2018
 */
public class HDT9 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));
        FactoryTree factoryTree = new FactoryTree(); //FACTORY
        InterArboles nueva = null; //INTERFACE
        RedBlackTree<Node<Association<String, String>>>redBlack = new RedBlackTree<>();//ASSOCIATION
        //Scanner entrada = new Scanner(System.in);
        String linea;
        int i=0;
        //aqui se hace el intento por obtener el archivo con sus informaicon    
        try {
            while (i==0){
                System.out.println("Ingrese el numero del arbol que desea usar");
                System.out.println("    1. Splay Tree");
                System.out.println("    2. Red Black Tree");
                System.out.println("    3. Ninguna, salir");
                //String opcion = entrada.nextLine();
                String opcion = "1";
                switch(opcion) {
                    case "1":
                        nueva = factoryTree.implementar("Splay Tree");
                        break;
                    case "2":
                        nueva = factoryTree.implementar("Red Black Tree");
                        break;
                    case "3":
                        i=1;
                        break;
                }
                if(i==0){
                    while ((linea=reader.readLine())!=null) {
                        String english;
                        String espanol;
                        builder.append(linea);
                        builder.append(System.lineSeparator()); 
                        linea = linea + " ";
                        for(int a=1;a<linea.length();a++){
                            String subs = linea.substring((a-1), a); 
                            if(subs.equals("\t")) {
                                if(linea.contains(",")){
                                    espanol = linea.substring(a, linea.indexOf(",")).toLowerCase();
                                }
                                else if(linea.contains(";")){
                                    espanol = linea.substring(a, linea.indexOf(";")).toLowerCase();
                                }
                                else{
                                    espanol = linea.substring(a, linea.length()-1).toLowerCase(); //se obtiene la subcadena luego de ","
                                }
                                english = linea.substring(0, a-1).toLowerCase(); //se obtiene la subcadena antes de "," 
                                nueva.put(english, espanol);
                            }
                        }
                    }
                    File nuevafrase = new File ("oracion.txt");
                    FileReader filereader = new FileReader (nuevafrase);
                    BufferedReader reader2 = new BufferedReader(filereader);
                    Scanner scanner = new Scanner(filereader);
                    String linea2 = "";
                    String texto = "";
                    while (scanner.hasNextLine()) {
                        linea2 += scanner.nextLine();
                        texto = linea2.replaceAll("\n", " ");
                    }
                    filereader.close();
                    reader2.close();
                    String oracion[]= texto.split(" ");
                    String traduccion = "";
                    String palabraIngles;
                    for(String palabra: oracion){
                        palabraIngles = palabra;
                        if (nueva.contains(palabraIngles)){
                            traduccion=traduccion+ nueva.get(palabraIngles)+ " ";
                        }
                        else{
                            traduccion=traduccion+ " *"+palabraIngles+ "* ";
                        }
                    }
                    System.out.println(traduccion);
                    i=1;
                }
            }
        }
        finally{
            reader.close();
        }
    }
}

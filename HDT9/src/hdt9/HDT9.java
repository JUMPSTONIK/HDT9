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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));    
        StringBuilder builder = new StringBuilder();
        String linea;
  
        InterArboles nueva = null;
        FactoryTree factoryTree = new FactoryTree();
        RedBlackTree<Node<Association<String, String>>>redBlack = new RedBlackTree<>();
        Scanner entrada = new Scanner(System.in);
        int i = 0;
        //aqui se hace el intento por obtener el archivo con sus informaicon    
        try {
            while (i==0){
                System.out.println("\n ¿Qué implementación desea usar? \n\t1. Red-Black Tree \n\t2. Splay Tree \n\t3. Salir");
                String opcion = entrada.nextLine();
                switch(opcion)
                {
                    case "1":
                        nueva = factoryTree.getTree("Red-Black Tree");
                        break;
                    case "2":
                        nueva = factoryTree.getTree("Splay Tree");
                        break;
                    case "3":
                        i=1;
                        break;
                }
                if(i == 0){
                    while ((linea=reader.readLine())!=null) {
                        String english;
                        String espanol;
                        builder.append(linea);
                        builder.append(System.lineSeparator()); 
                        linea = linea + " ";
                        for(int a=1;a<linea.length();a++){
                            String subs = linea.substring((a-1), a); 
                            if(subs.equals("\t"))
                            {
                                if(linea.contains(",")){
                                    espanol = linea.substring(a, linea.indexOf(",")).toLowerCase();
                                }else if(linea.contains(";")){
                                    espanol = linea.substring(a, linea.indexOf(";")).toLowerCase();
                                }else{
                                    espanol = linea.substring(a, linea.length()-1).toLowerCase(); //se obtiene la subcadena luego de ","
                                }
                                english = linea.substring(0, a-1).toLowerCase(); //se obtiene la subcadena antes de "," 
                                nueva.put(english, espanol);
                            }
                        }
                    }
                    File archivo = new File ("oracion.txt");
                    FileReader filereader = new FileReader (archivo);
                    BufferedReader reader2 = new BufferedReader(filereader);
                    String linea2 = "";
                    Scanner scanner = new Scanner(filereader);
                    String texto = "";
                    while (scanner.hasNextLine()) {
                        linea2 += scanner.nextLine();
                        texto = linea2.replaceAll("\n", " ");
                    }
                    filereader.close();
                    reader2.close();
                    String oracion[] = texto.split(" ");
                    String traduccion = "";
                    String palabraIngles;
                    for(String p: oracion){
                        palabraIngles = p.toLowerCase();
                        if (nueva.contains(palabraIngles))
                            traduccion =traduccion+ nueva.get(palabraIngles).toUpperCase() + " ";
                        else
                            traduccion =traduccion+ " **"+palabraIngles.toUpperCase() + "** ";
                        }
                    System.out.println(traduccion);
                    i = 1;
                }
            }
        }
        finally{
            reader.close();
        }
    }
}

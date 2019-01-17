/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author 2098325
 */
public class main {

    private static  List<String>pal=new ArrayList<String>();
    static Hashtable<String, Integer> numpal = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> numpal2 = new Hashtable<String, Integer>();    
    public static void main(String[] args) throws IOException {
        //Leer texto
        muestraContenido("/home/2098325/Downloads/Lab1/mavenproject1/datos.txt");
    }
    
    

    static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      int cont=0;
      while((cadena = b.readLine())!=null) {
          //System.out.println("cadena "+cadena);
          
          if(cont>=2){
              //System.out.println("entrampo");
              comparar();
              pal.clear();
              numpal.clear();
              numpal2.clear();
              pal.add(cadena);
              //System.out.println("agregando "+cadena);
              cont=0;
          }else{
              //System.out.println("agregando "+cadena);
              pal.add(cadena);
              cont++;
              
          
          }

      }
      comparar();
      b.close();
    }
       
    static void comparar(){
        
        for(int i=0; i<pal.size();i++){
            String tmp=pal.get(i);
            System.out.println("palabra es "+tmp+"TAMAPA"+pal.size());
            String[] g =tmp.split("");
            for(int u=0; u<g.length;u++){
                if(i==0){
                    //System.out.println("que queremos meter "+g[u]);
                    if(numpal.containsKey(g[u])){
                        System.out.println("agregamos  "+g[u]);
                        int tmpp=numpal.get(g[u]);
                        tmpp=tmpp+1;
                        numpal.remove(tmpp);
                        numpal.put(g[u], tmpp);
                    }else{
                        System.out.println("nuevo  "+g[u]);
                        numpal.put(g[u], 1);
                    }
                }
                else if(i==1){
                    if(numpal2.containsKey(g[u])){
                        int tmpp=numpal2.get(g[u]);
                        tmpp=tmpp+1;
                        numpal2.remove(tmpp);
                        numpal2.put(g[u], tmpp);
                    }else{
                        numpal2.put(g[u], 1);
                    }                    
                }
            }       
        }
        Collection<Integer> resp1 =numpal.values();
        
        Collection<Integer> resp2 =numpal2.values();
        
        System.out.println("uiui "+resp1);
        System.out.println("uiui "+resp2);
        
        
        
        
    }
    
    
}

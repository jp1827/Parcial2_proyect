/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jr.parcial2;

 /*********************************************************************************************
 * Baraja.java
 * Roberto Sanchez
 * Jose López
 *
 * Clase con métodos principales, creación de baraja y main para correr el juego "Siete y media"
 ***********************************************************************************************/

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.LinkedHashMap;

public class Baraja
{
   
    //SE DECLARAN LAS COLECCIONES
    TreeMap<Integer, Carta> colecion1 = new TreeMap<Integer, Carta>(); //COLECCION PARA CREAR LA BARAJA DE CARTAS ORDENADA
    LinkedHashMap <Integer, Carta> Coleccion_Barajeada = new LinkedHashMap<Integer, Carta>(); //COLECCION PARA GUARDAR LAS CARTAS BARAJEADAS (PARA TENER EL INDICE)
    LinkedHashMap <Integer, Carta> coleccion_Barajeada_clon = new LinkedHashMap<Integer, Carta>(); //COLECCION PARA GUARDAR LAS CARTAS BARAJEADAS COPIA (PARA ENTREGAR Y REMOVER CARTAS)
    public static int Cartas_Num = 40; //CARGA EL NUMERO DE CARTAS A UTILIZAR EN MAZO       
    int num = 0; //OBTENER LA PRIMERA LLAVE DE LA COLECCION CLON PARA ENTREGARLA AL JUGADOR 


    //CREACION DE LA BARAJA Y CARGA LOS DATOS EN LA COLECCION TREEMAP
    public void Crear_Baraja()
    {
        String [] p = Carta.Palos; //SE MANDA A LLAMAR LA LISTA DE PALOS CREADA EN LA CLASE "CARTA"
        
        for (int i = 0; i < p.length ; i++)
        {            
            for (int j = 0; j < Carta.Num_Cartas_Palos; j++)
            {
                if (!(j == 7 || j == 8 || j == 9) ) // CONDICION PARA QUE NO GUARDE LOS NUMEROS MENCIONADOS
                {   
                   if (j >= 10) 
                   {
                    colecion1.put(((i * (Carta.Num_Cartas_Palos - 3)) + (j - 2)), new Carta((j + 1), p[i], 0.5));
                   }
                   else
                   {
                    colecion1.put(((i * (Carta.Num_Cartas_Palos - 3)) + (j + 1)), new Carta((j + 1), p[i], (j + 1)));
                   }
                }
            }
        }
    }    



    //METODO PARA BARAJEAR EL MAZO DE CARTAS CREADO ANTERIORMENTE Y CARGADAS EN LA COLECCION LINKEDHASHMAP
    public void Barajear()
    {
        Crear_Baraja();
        int aleatorio = 0; // VARIABLE PARA CREAR LA LLAVE ALEATORIA

        for (int i = 0; i < Cartas_Num; i++) //SE RECORRE CON LA CANTIDAD TOTAL DE CARTAS EN EL MAZO
        {
            aleatorio = metodos.generaNumeroAleatorio(colecion1.firstKey(), colecion1.lastKey()); //SE USA UN METODO GENERADOR DE UN NUMERO RANDOM

            if (colecion1.containsKey(aleatorio) == true) //SI LA LLAVE EXISTE QUE LO GUARDE
            {                
                Coleccion_Barajeada.put((aleatorio), new Carta (colecion1.get(aleatorio).numero, colecion1.get(aleatorio).palo, colecion1.get(aleatorio).valor)); //SE GUARDAN LOS DATOS EN LA COLECCION
                coleccion_Barajeada_clon.put((aleatorio), new Carta (colecion1.get(aleatorio).numero, colecion1.get(aleatorio).palo, colecion1.get(aleatorio).valor)); //SE GUARDAN LOS DATOS EN LA COLECCION COPIA
                colecion1.remove(aleatorio);  
            }
            else
            {
                i = i - 1; //SI LA LLAVE NO EXISTE QUE NO SIGA SUMANDO EL CICLO
            }
        }              
    }


    //MÉTODO PARA DAR UNA CARTA (Estructura de carta)
    public String Dar_Carta()
    {   
        // VERIFICAR SI LA COLECCION TIENE ALGO AMACENADO O SI ESTA VACÍA PARA DAR CARTAS A LOS JUGADORES
        if (coleccion_Barajeada_clon.isEmpty() == false)
        {             
            //CODIGO QUE RECORRE EL MAPA Y QUE OBTIENE LA PRIMERA LLAVE DEL MAPA
            final Set<Entry<Integer, Carta>> va = coleccion_Barajeada_clon.entrySet();
            final int maplength = va.size();
            final Entry<Integer,Carta>[] test = new Entry[maplength];
            va.toArray(test);

        
            num = test[0].getKey(); //SE GUARDA PRIMERA LLAVE EN UNA VARIABLE PARA MANDARLA A LLAMAR

                    
            coleccion_Barajeada_clon.remove(num);            
            return String.valueOf(Coleccion_Barajeada.get(num));         
        }
        else
        {
            return null;
        }
        
    }
    
    //MÉTODO PARA DAR UNA CARTA (Valor de carta)
    public double retornarValor()
    {
        return Coleccion_Barajeada.get(num).valor;
    }
    
}

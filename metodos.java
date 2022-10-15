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
 * Clase con método de generación de números aleatorios
 ***********************************************************************************************/

public class metodos {
    public static int generaNumeroAleatorio(int minimo,int maximo)
    {
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}

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
 * Clase Carta para mandar palos y numeros a la clase Bajara para el juego "Siete y media"
 ***********************************************************************************************/

class Carta {

        Integer numero;
        String palo;
        double valor;
        
        public static String [] Palos = {"Corazones", "Diamantes", "Trebol", "Picas"};
        public static int Num_Cartas_Palos = 13;
    
        public Carta(Integer numero, String palo, double valor)
        {            
            this.numero = numero;
            this.palo = palo;
            this.valor = valor;
        }
    
        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public String getPalo() {
            return palo;
        }

        public void setPalo(String palo) {
            this.palo = palo;
        }

        @Override
        public String toString() {
            return Rangos()+"  de  "+this.palo ;
        }

        public String Rangos()
        {
            switch(this.numero)
            {
                case 1:
                    return "As";
                case 11:
                    return "J";
                case 12:
                    return "Q";
                case 13:
                    return "K";
                default:
                    return String.valueOf(numero);
            }
        }    
}

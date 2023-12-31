package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ClientesMonitor {
    private static ArrayList<Boolean> clientes = new ArrayList<>(10);
    private static boolean lecturaLlena = true;
    private static boolean lecturaVacia = true;

    public ClientesMonitor() {
    }

    /**
     *
     * @param p -> este sera un objeto Portero para identificar por cual
     *              puerta ha entrado
     * @throws InterruptedException
     */
    public  void entradaCliente(Portero p) throws InterruptedException {

       if (comprobarLista()){
           System.out.println("Portero puerta: "+p.getNumero()+
                   " Ha entrado un cliente. En sala hay: "+
                   (clientes.size()));
           lecturaVacia = true;
           //Notificaremos a un monitor de tipo salidaCliente() que se haya quedado wait() por sala vacia

       } else if (!comprobarLista()) {
           if (lecturaLlena){
               System.out.println("Portero puerta: "+p.getNumero()+
                       " La sala esta llena. En la sala hay: "+
                       (clientes.size()));
               lecturaLlena = false;
           }

           //Bloquearemos el monitor hasta que salidaCliente() notifique que ha salido un cliente

       }
        //codigo para probar un funcionamiento espaciado de funcioens
       Thread.sleep(new Random().nextInt(499)+1);
    }

    /**
     *
     * @param p -> este sera un objeto Portero para identificar por cual
     *          puerta ha salido
     * @throws InterruptedException
     */
    public  void salidaCliente(Portero p) throws InterruptedException {
        if (quitarLista()){
            System.out.println("Portero puerta: "+
                    p.getNumero()+" Ha salido un cliente quedan : "+
                    (clientes.size()));
            lecturaLlena = true;
            //Notificaremos a los hilos, un cliente se puede quedar wait() si la sala esta llena.

        } else if (!quitarLista()) {
            if (lecturaVacia){
                System.out.println("Portero puerta: "+
                        p.getNumero()+
                        " Sala vacia");
                lecturaVacia = false;
            }

            //en caso de que la sala este vacia esperaremos a que entre un cliente

        }

        //codigo para probar un funcionamiento espaciado de funcioens
        Thread.sleep(new Random().nextInt(499)+1);
    }

    public boolean comprobarLista(){
        //si el tamaño de la lista es menor a 10 quiere dechir que no esta llena la sala
       if (clientes.size()<10 ){
            clientes.add(true);
            return true;
       }else {
           return false;
       }

    }

    public boolean quitarLista(){
            //si la lista no esta vacia quiere decir que hay gente, por lo que removemos a un cliente
           if (!clientes.isEmpty()){
               clientes.remove(clientes.size()-1);
               return true;
           }else{
               return false;
           }

    }


}

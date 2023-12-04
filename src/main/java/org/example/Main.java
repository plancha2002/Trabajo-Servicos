package org.example;

public class Main {
    public static void main(String[] args) {

        /**
         * Se crea un monitor, 2 cliente y dos porteros debido a que se piden que puedan
         * entrar y salir por las dos puertas, asi simulamos que hay dos porteros reciendo clientes
         */
        ClientesMonitor c = new ClientesMonitor();
        Portero p1 = new Portero(c,"1");
        Portero p2 = new Portero(c,"2");
        Clientes c1 = new Clientes(p1, c);
        Clientes c2 = new Clientes(p2, c);
       c1.start();
        c2.start();
        p1.start();
        p2.start();
    }
}
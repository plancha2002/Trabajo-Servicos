package org.example;

public class Clientes extends Thread{
    private Portero portero;
    private ClientesMonitor lista;

    public Clientes(Portero portero, ClientesMonitor lista) {
        this.portero = portero;
        this.lista = lista;
    }

    @Override
    public void run() {
        do{
            try {
                lista.entradaCliente(portero);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(true);

    }
}

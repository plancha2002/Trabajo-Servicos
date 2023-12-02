package org.example;

public class Portero extends Thread{
    private ClientesMonitor clientes;
    private String numero;

    public Portero(ClientesMonitor clientesMonitor, String numero) {
        this.clientes = clientesMonitor;
        this.numero = numero;
    }

    @Override
    public void run() {
        do{
            try {


                clientes.salidaCliente(this);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }while(true);
    }

    public String getNumero() {
        return numero;
    }
}

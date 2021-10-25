package com.company;

public class Cliente implements Runnable {

    //Crear los cajeros
    String cajeros;
    String[] cajero = {"Caja 1", "Caja 2", "Caja 3", "Caja 4", "Caja 5"};

    //Crear los clientes y la cesta
    String cliente;
    String[] nombre = {"Manolo", "Pedro", "Cristian", "Jose", "Manuel"};
    Cesta cesta = new Cesta();

    float gastado = 0;

    public Cliente(String cliente) {
        this.cliente = cliente;
    }


    @Override
    public void run() {

        cajeros = cajero[(int)(Math.random() * cajero.length)];
        cliente = nombre[(int) (Math.random() * nombre.length)];

        Compra(cajeros, cliente);
    }

    public void Compra(String caixa, String client){

        try {
            for (Productos product: cesta.call()) {
                gastado += product.precio;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String formattedString = String.format("%.2f", gastado);
        System.out.println("|| " + caixa + " || " + client + " -->" +  " Dinero a pagar: " + formattedString +" €");

    }
}

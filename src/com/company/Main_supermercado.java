package com.company;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_supermercado {

    public static void main(String[] args) {

        //Crear lista de clientes

        ArrayList<Cliente> clientes = new ArrayList<>();

        for (int i = 1; i < Math.random()*5+2; i++) {
            clientes.add(new Cliente("Cliente" + i));
        }
        for (Cliente cliente : clientes){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {

                cliente.run();
                executor.shutdown();

            });
        }
    }
}
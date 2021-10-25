package com.company;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Cesta implements Callable<ArrayList<Productos>> {

    ArrayList<Productos> productos;
    Estanterias estanterias = new Estanterias();

    @Override
    public ArrayList<Productos> call() throws Exception {

        productos = new ArrayList<>();

        for (int i = 0; i < Math.random()*13; i++) {

            //Elige un producto aleatorio que luego será añadido a la cesta

            int numero = (int) (Math.random()* estanterias.nombreProd.length);
            productos.add(new Productos(estanterias.nombreProd[numero], estanterias.precioProd[numero]));

        }

        return productos;

    }
}
    





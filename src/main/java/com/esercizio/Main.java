package com.esercizio;

public class Main {
    public static void main(String[] args) {

        ContoCorrente conto = new ContoCorrente(1000); // Saldo iniziale 1000 €

        Prelevatore t1 = new Prelevatore(conto, "Cliente-1", 700);
        Prelevatore t2 = new Prelevatore(conto, "Cliente-2", 500);

        Versatore v1 = new Versatore(conto, "Cliente-1", 400);

        t1.start();
        t2.start();
        v1.start();
    }
}
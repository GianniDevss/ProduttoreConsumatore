package com.esercizio;
import java.util.concurrent.Semaphore;

class ContoCorrente {
    private int saldo;
    private Semaphore semaforo = new Semaphore(1);

    public ContoCorrente(int saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    public void preleva(int importo) {

        
        try {
            semaforo.acquire();

            System.out.println(Thread.currentThread().getName() + " tenta di prelevare " + importo + "€");

            if (saldo >= importo) {
                System.out.println(Thread.currentThread().getName() + " prelievo riuscito!");
                saldo -= importo;
            } else {
                System.out.println(Thread.currentThread().getName() + " prelievo fallito: saldo insufficiente (" + saldo + "€ disponibili)");
            }
            System.out.println("Saldo attuale: " + saldo + "€");

            

        } catch (InterruptedException e) { }
        finally {
            semaforo.release();
        }
    }

    public void versa(int importo) {

        
        try {
            semaforo.acquire();
            
            System.out.println(Thread.currentThread().getName() + " tenta di versare " + importo + "€");

                System.out.println(Thread.currentThread().getName() + " versamento riuscito!");
                saldo += importo;
            System.out.println("Saldo attuale: " + saldo + "€");

        } catch (InterruptedException e) { }

        finally {
            semaforo.release();
        }
    }
}
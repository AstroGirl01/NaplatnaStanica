/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naplatnastanica;

import java.util.Random;

/**
 *
 * @author Kiki
 */
public class Rampa {
    private String nazivRampe;
    private int tsr;
    private boolean otvorena;
    private final Stanica[] stanice;
    private final int brStanica;
  
    public Rampa(int brStanica, int tsr, String nazivRampe, Stanica osnov){
        this.nazivRampe = nazivRampe;
        this.brStanica = brStanica;
        this.stanice = new Stanica[brStanica];
        this.tsr = tsr;
        for (int a = 0; a < brStanica; a++) {
            this.stanice[a]=osnov.copy();
        } 
        this.otvorena = false;
        
    }
    

    public synchronized void otvori(Cenovnik cenovnik) {
        for (int a = 0; a < brStanica; a++) {
            this.stanice[a].setCenovnik(cenovnik);
        } 
        this.otvorena = true;
        pokreniSimulaciju();
        System.out.println("Naplatna rampa " + nazivRampe + " je otvorena");
    
    }
    
    public synchronized void zatvori() {
        this.otvorena = false;
        System.out.println("Naplatna rampa " + nazivRampe + " je zatvorena");

        
    }
    private synchronized void pokreniSimulaciju() {
        new Thread(() -> {
            try {
                while (otvorena) {
                    Random rand = new Random();
                    int kategorija = rand.nextInt(3);
                    Vozilo vozilo = new Vozilo(kategorija);
                    Stanica stanica = stanice[rand.nextInt(this.brStanica)];
                    int zaNaplatu = stanica.naplatiPutarinu(kategorija);
                    System.out.println("Proslo vozilo"+ kategorija+" na stanicu" + stanica.getId()+ " naplaceno" + zaNaplatu);
                    Thread.sleep(1000+(rand.nextInt(2)==0?1:-1)*tsr);
                }
            } catch (InterruptedException ex) {
                System.out.println("Greska" + ex);
            }
        }
        ).start();
    }

    public int izracunajNaplacenIznos() {
        int ukupanIznos = 0;
        for (int a = 0; a < brStanica; a++) {
            ukupanIznos+=this.stanice[a].getUkupnoNaplaceno();
        } 
        return ukupanIznos;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nazivRampe + "(" + izracunajNaplacenIznos() + "):");
        for (Stanica stanica : stanice) {
            sb.append(stanica).append(", ");
        }
        return sb.toString();
    }
    
}

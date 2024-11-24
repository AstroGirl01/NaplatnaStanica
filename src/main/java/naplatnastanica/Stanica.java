/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naplatnastanica;

/**
 *
 * @author Kiki
 */
public class Stanica {
    private static int statId = 0;
    private int id;
    private Cenovnik cenovnik;
    private int ukupnoNaplaceno = 0;
    
    public Stanica(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
        this.id = ++statId;
    }
    
    public int getId() {
        return id;
    }
    
    public int naplatiPutarinu(int kategorija) {
        int zaNaplatu = cenovnik.putarinaZaKategoriju(kategorija);
        ukupnoNaplaceno+=zaNaplatu;
        return zaNaplatu;
        
    }
    
    public int getUkupnoNaplaceno() {
        return this.ukupnoNaplaceno;
    }
    
    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
        this.ukupnoNaplaceno = 0;
    }
    
    public Stanica copy() {
        return new Stanica(this.cenovnik);
    }
    
    @Override
    public String toString() {
        return "Stanica" + id + "(" + this.ukupnoNaplaceno + ")";
    }
}

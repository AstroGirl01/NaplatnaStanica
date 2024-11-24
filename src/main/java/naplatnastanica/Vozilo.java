/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naplatnastanica;

/**
 *
 * @author Kiki
 */
public class Vozilo extends Kategorizovano {
    private int id;
    private static int statId = 0;
    private int kategorija;
    
    public Vozilo (int kategorija) {
        this.id = ++statId;
        this.kategorija = kategorija;
    }
    
    public int getId() {
        return id;
    }
    public String toString() {
        return "Vozilo [Oznaka: " + id + ", Kategorija:" + kategorija + "]";
    }
    
}

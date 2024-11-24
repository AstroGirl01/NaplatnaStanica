package naplatnastanica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Cenovnik {
    private int[] putarine; 
    // Konstruktor: Inicijalizuje cenovnik sa zadatim nizom putarina
    public Cenovnik(int[] putarine) {
        if (putarine == null || putarine.length == 0) {
            throw new IllegalArgumentException("Niz putarina ne sme biti prazan.");
        }
        this.putarine = putarine.clone(); // Pravimo kopiju kako bismo zaštitili originalni niz
    }

 
    public int brojKategorija() {
        return putarine.length;
    }

    // Metoda za dohvat putarine za zadatu kategoriju
    public int putarinaZaKategoriju(int kategorija) {
        if (kategorija < 0 || kategorija > putarine.length) {
            throw new IllegalArgumentException("Nepostojeća kategorija: " + kategorija);
        }
        return putarine[kategorija]; // Indeksi niza su 0-bazirani, dok su kategorije 1-bazirane
    }

    // Override za prikaz stanja cenovnika
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cenovnik:\n");
        for (int i = 0; i < putarine.length; i++) {
            sb.append("Kategorija ").append(i + 1).append(": ").append(putarine[i]).append("\n");
        }
        return sb.toString();
    }
}


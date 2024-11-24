/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package naplatnastanica;

/**
 *
 * @author Kiki
 */
public class NaplatnaStanica {

    public static void main(String[] args) throws InterruptedException {
        // Cenovnik za 3 kategorije vozila
        int[] putarine = {100, 200, 300};
        Cenovnik cenovnik = new Cenovnik(putarine);
        
        // Otvaranje rampe
      Rampa rampa = new Rampa(3,200,"rampa1", new Stanica(cenovnik));
      rampa.otvori(cenovnik);
      Thread.sleep(2000);
      
      rampa.zatvori();
      System.out.println(rampa);
      
     
        
        
        
        
        
        
    }
}

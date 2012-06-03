/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crystalandmana;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shivanth
 */
public class CrystalAndMana {
    static int n,mana_per_swap;
    static ArrayList <Triplet> set;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        mana_per_swap=scan.nextInt();
        set=new ArrayList<>(n);
        read_triplets(scan);
        
        
        
    }
    
    public static void read_triplets(Scanner s){
        for(int i=0;i<n;i++){
            set.add(new Triplet(s.nextInt(), s.nextInt(), s.nextInt()));
        
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crystalandmana;

import java.util.*;

/**
 *
 * @author shivanth
 */
public class CrystalAndMana {

    static int n, mana_per_swap,swaps;
    static ArrayList<Triplet> set;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        mana_per_swap = scan.nextInt();
        set = new ArrayList<>(n);
        read_triplets(scan);
simple_search();


    }

    public static void read_triplets(Scanner s) {
        for (int i = 0; i < n; i++) {
            set.add(new Triplet(s.nextInt(), s.nextInt(), s.nextInt()));

        }
    }

    public static void swap(Triplet a, Triplet b, char color) {
        int temp;
        switch (color) {
            case 'r':
                temp = a.getR();
                a.setR(b.getR()+1);
                b.setR(temp+1);
                break;
            case 'g':
                temp = a.getG();
                a.setG(b.getG()+1);
                b.setG(temp+1);
                break;
            case 'b':
                temp = a.getB();
                a.setB(b.getB()+1);
                b.setB(temp+1);
                break;// b.setR is at function end;

        }
        swaps++;
    }
    
    static int score(){
        int score = 0;
    
        for(Triplet t:set){
        score+=t.getProduct();
        
    }
        score+=swaps*mana_per_swap;
        return score;
    }
    static void simple_search() {
        ArrayList<Triplet> a;
        Collections.sort(a = (ArrayList<Triplet>) set.clone(), new Triplet_comparator());
        ListIterator front = a.listIterator();
        ListIterator back = a.listIterator(a.size());
        Triplet A,B;
        int r_diff,g_diff,b_diff;
        while (front != back) {
            A=(Triplet)front.next();
            B=(Triplet)back.previous();
            r_diff=A.getR()-B.getR();
            g_diff=A.getG()-B.getG();
            b_diff=A.getB()-B.getB();
            if(r_diff>g_diff){
                if(r_diff > b_diff){
                    swap(A,B,'r');
                }
                else if (r_diff < b_diff){
                    swap(A,B,'b');
                }
            }
            else if (r_diff < g_diff) {
                if(g_diff > b_diff){
                    swap(A,B,'g');
                }
                else if (g_diff < b_diff) {
                    swap(A,B,'b');
                }
            }
        }
        
    }
}

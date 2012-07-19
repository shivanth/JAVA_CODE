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
    static ArrayList<Integer> output_array;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        mana_per_swap = scan.nextInt();
        set = new ArrayList<>(n);
        output_array=new ArrayList<>();
        read_triplets(scan);
        simple_search();
        System.out.println(score());
        print_output();
        


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
        char undo = 0 ;
        Collections.sort(a = (ArrayList<Triplet>) set.clone(), new Triplet_comparator());
        ListIterator front = a.listIterator();
        ListIterator back = a.listIterator(a.size());
        Triplet A,B;
        int r_diff,g_diff,b_diff,score,index=0;
        while ((A=(Triplet)front.next()) !=(B=(Triplet) back.previous())) {
            score=score();
            System.out.println(score);
            //A=(Triplet)front.next();
            //B=(Triplet)back.previous();
            r_diff=A.getR()-B.getR();
            g_diff=A.getG()-B.getG();
            b_diff=A.getB()-B.getB();
            if(r_diff>=g_diff){
                if(r_diff > b_diff){
                    swap(A,B,'r');
                    undo='r';
                    output_array.add(1);
                }
                else if (r_diff <= b_diff){
                    swap(A,B,'b');
                    undo='b';
                    output_array.add(3);
                }
            }
            else if (r_diff < g_diff) {
                if(g_diff > b_diff){
                    swap(A,B,'g');
                    undo='g';
                    output_array.add(2);
                }
                else if (g_diff <= b_diff) {
                    swap(A,B,'b');
                    undo='b';
                    output_array.add(3);
                }
            }
            output_array.add(set.indexOf(A)+1);
            output_array.add(set.indexOf(B)+1);
            if(score<=score()){
                undo_swap(A,B,undo);
                output_array.remove(3*index);
                output_array.remove(3*index+1);
                output_array.remove(3*index+2);
            }
            index++;
        }
        
    }

    private static void undo_swap(Triplet a,Triplet b,char undo) {
        int temp;
        switch (undo) {
            case 'r':
                temp = a.getR();
                a.setR(b.getR()-1);
                b.setR(temp-1);
                break;
            case 'g':
                temp = a.getG();
                a.setG(b.getG()-1);
                b.setG(temp-1);
                break;
            case 'b':
                temp = a.getB();
                a.setB(b.getB()-1);
                b.setB(temp-1);
                break;// b.setR is at function end;

        }
        swaps--;
    }

    private static void print_output() {
        int j=0;
        for(int i : output_array){
            
            System.out.print(i+" ");
            if(j==2){
            j=0;
            System.out.println();
        }
            j++;
        }
    }
}

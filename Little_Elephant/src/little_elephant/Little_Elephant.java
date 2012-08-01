/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package little_elephant;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shivanth
 */
public class Little_Elephant {

    static int T_num, B_num;
    static ArrayList<String> tc_data;
    static Scanner input;
    //static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        tc_data = new ArrayList<>();
        input = new Scanner(System.in);
        read_data();
        for (String s : tc_data) {
            solve(s);
        }
    }

    public static void solve(String s) {
        char buildings[] = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            try {
                if (s.charAt(i) == '1') {
                    
                    if (i != 0 && i != s.length() - 1) {
                        buildings[i - 1] = (char) -1;
                        buildings[i] = (char) -1;
                        buildings[i + 1] = (char) -1;
                    }
                    else if (s.length()==1){
                        buildings[0]=(char)-1;
                    }else if (i == 0) {
                        buildings[i] = (char) -1;
                        buildings[i + 1] = (char) -1;
                    } else if (i == s.length() - 1) {
                        buildings[i - 1] = (char) -1;
                        buildings[i] = (char) -1;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error when accessing array when array index =" + i+"for string="+s);
            }

        }
        System.out.println(count(buildings));
    }

    static int count(char[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count++;
            }
        }
        return count;
    }

    static void read_data() {
        int size = 0;
        String data;
        BigInteger bd;
        T_num = Integer.parseInt(input.nextLine());
        for (int i = 0; i < T_num; i++) {
            size = Integer.parseInt(input.nextLine());
            data=input.nextLine();

            //data = input.nextLine();

            tc_data.add(data);

        }
    }
}

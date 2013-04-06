/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/*
 * Problem Statement
    
John has a sequence of integers. Brus is going to choose two different positions in John's sequence and swap the elements at those positions. (The two swapped elements may have the same value.) Return the number of different sequences Brus can obtain after he makes the swap.
Definition
    
Class:
TheSwapsDivTwo
Method:
find
Parameters:
vector <int>
Returns:
int
Method signature:
int find(vector <int> sequence)
(be sure your method is public)
    

Constraints
-
sequence will contain between 2 and 47 elements, inclusive.
-
Each element of sequence will be between 1 and 47, inclusive.
Examples
0)

    
{4, 7, 4}
Returns: 3
If Brus swaps elements 0 and 1 (0-based indices), the sequence will change to {7, 4, 4}. If he swaps elements 1 and 2 instead, the sequence will change to {4, 4, 7}. Finally, if the swaps elements 0 and 2, the sequence will remain {4, 7, 4}. These three outcomes are all distinct.
1)

    
{1, 47}
Returns: 1
Brus has to swap the only two elements, producing the sequence {47, 1}. Note that Brus has to make the swap, he cannot keep the original sequence.
2)

    
{9, 9, 9, 9}
Returns: 1
Regardless of which two elements Brus swaps, the resulting sequence will always be {9, 9, 9, 9}.
3)

    
{22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37}
Returns: 319

 
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
package pkg250.pt;

/**
 *
 * @author Shivanth
 */
public class Pt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a []={22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37};//{4,7,4};
        System.out.println(find(a));
        System.out.println(sum(a.length));
    }
    
    static public int find(int[] sequence) {
        int map[]=new int [50];
        boolean flag=false;
	for(int i=0;i<sequence.length;i++){
            map[sequence[i]]++;
        }
        
        int val=sum(sequence.length);
        for(int i=1;i<=48;i++){
            if(map[i]>1){
            int temp=sum(map[i]);
            val-=temp;
            flag=true;
            }
            if(sequence.length==map[i])
                return 1;
        }
        if(flag==true)
        return val+1;
        else return val;
	}
    
    static public int sum(int i){
        int sum=0;
    
        for(int j=1;j<i;j++){
         sum+=j;   
        }
        return sum;
}
}
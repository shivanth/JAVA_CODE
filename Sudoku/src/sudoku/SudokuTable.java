/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

/**
 *
 * @author Shivanth
 */
public class SudokuTable {
     int data[][];
     SudokuTable(){
         data=new int[10][10];
     }
     public void setdata(int row,int col,int value){
         data[row][col]=value;
              }
     public int getdata(int row,int col){
         return data[row][col];
     }
     public int [] getrow(int i){
         return data[i];
     }
    @Override
     public String toString(){
         StringBuffer s=new StringBuffer();
         for (int i=1;i<10;i++){
             for(int j=1;j<10;j++){
                 s.append(" ");
                 s.append(data[i][j]);
             }
             s.append("\n");
         }
         return s.toString();
     }

    public boolean issolved(){
        //if (Main.isRunning()){
        //    return false;
        //}
        for (int i=1;i<10;i++){
            for (int j=1;j<10;j++){
             if(getdata(i,j)<1 || getdata(i,j)>9)
                 return false;//If everything is solved then all columns will be having values from 1 to 9 and not zeroes
            }
        }
        return true;
    }

}

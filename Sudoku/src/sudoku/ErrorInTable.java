/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

/**
 *
 * @author Shivanth
 */
public class ErrorInTable  extends Exception {
    int row,col;
    ErrorInTable(){

    }
    ErrorInTable(int i,int j){

    }

    @Override
        public  String toString(){
        String s=super.toString();
        return s+" "+row+ " "+col;
    }

}

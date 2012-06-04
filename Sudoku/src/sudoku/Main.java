/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Shivanth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        
        //getdata(maintable);
        SudokuFrame sf = new SudokuFrame();
        sf.pack();
        sf.setVisible(true);
        
        

        //System.out.print(maintable);
        

    }
    /*
    @SuppressWarnings("empty-statement")
    public static void getdata(SudokuTable table) {

    table.setdata(1, 3, 8);
    table.setdata(1, 5, 2);
    table.setdata(1, 8, 1);
    table.setdata(2, 1, 3);
    table.setdata(2, 4, 8);
    table.setdata(2, 5, 7);
    table.setdata(2, 8, 5);
    table.setdata(3, 1, 5);
    table.setdata(3, 8, 2);
    table.setdata(4, 1, 8);
    table.setdata(4, 3, 4);
    table.setdata(4, 4, 6);
    table.setdata(5, 3, 1);
    table.setdata(5, 5, 5);
    table.setdata(5, 7, 9);
    table.setdata(6, 6, 3);
    table.setdata(6, 7, 2);
    table.setdata(6, 9, 4);
    table.setdata(7, 2, 4);
    table.setdata(7, 9, 2);
    table.setdata(8, 2, 8);
    table.setdata(8, 5, 1);
    table.setdata(8, 6, 6);
    table.setdata(8, 9, 7);
    table.setdata(9, 2, 2);
    table.setdata(9, 5, 4);
    table.setdata(9, 7, 1);

    SudokuFrame sf=new SudokuFrame(table);

    sf.pack();
    sf.setVisible(true);
    while(!sf.isdone());
    sf.setVisible(false);
    //sf=null;
    }
     * * */
}

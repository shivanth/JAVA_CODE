/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Shivanth
 */
public class Main {

    private static boolean running=true;
    private static SudokuFrame sf;
    static final Logger log = Logger.getLogger("MyLog");
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here


        //getdata(maintable);
        
        FileHandler fh;  
          
        try {  
             // log = Logger.getLogger("MyLog");
            // This block configure the logger with handler and formatter  
            fh = new FileHandler("MyLogFile.log");  
            log.addHandler(fh);  
            //logger.setLevel(Level.ALL);  
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
              
            // the following statement is used to log any messages  
            log.info("My first log");  
              
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
       
        sf = new SudokuFrame();
        getSf().pack();
        getSf().setVisible(true);



        //System.out.print(maintable);


    }

    static void main_loop(SudokuTable maintable) {
        boolean done = false;
        ProbTable prob[] = new ProbTable[10];
        for (int i = 1; i < 10; i++) {
            prob[i] = new ProbTable();
        }





        for (int i = 1; i < 10; i++) {
            try {
                prob[i].init_fill_table(maintable, i);
            } catch (DataInvalidException ex) {
            } catch (ErrorInTable ex) {
            }
        }




        while (!done && isRunning()) {
            log.info(maintable.toString());
            done = true;
            for (int i = 1; i < 10; i++) {
                if (prob[i].scan_table(maintable)) {
                    done = false;
                    for (int j = 1; j < 10; j++) {
                        if (j == i) {


                            try {
                                prob[i].kill_row(ProbTable.getROW());
                                prob[i].kill_column(ProbTable.getCOLUMN());
                                prob[i].kill_box(ProbTable.getROW(), ProbTable.getCOLUMN());
                                prob[i].writecell(ProbTable.getROW(), ProbTable.getCOLUMN(), ProbTable.GUESS_MAX);
                                maintable.setdata(ProbTable.getROW(), ProbTable.getCOLUMN(), i);
                                System.out.print(maintable);
                                System.out.println("");
                                System.out.println("");

                            } catch (ErrorInTable ex) {
               
                            }
                            //prob[i].writecell(ProbTable.getROW(), ProbTable.getCOLUMN(), ProbTable.GUESS_MAX);
                            continue;
                        } else {
                            prob[j].killcell(ProbTable.getROW(), ProbTable.getCOLUMN());
                        }
                    }
                }
            }

        }
        sf.display_results(maintable);
    }
    /*
     * @SuppressWarnings("empty-statement") public static void
     * getdata(SudokuTable table) {
     *
     * table.setdata(1, 3, 8); table.setdata(1, 5, 2); table.setdata(1, 8, 1);
     * table.setdata(2, 1, 3); table.setdata(2, 4, 8); table.setdata(2, 5, 7);
     * table.setdata(2, 8, 5); table.setdata(3, 1, 5); table.setdata(3, 8, 2);
     * table.setdata(4, 1, 8); table.setdata(4, 3, 4); table.setdata(4, 4, 6);
     * table.setdata(5, 3, 1); table.setdata(5, 5, 5); table.setdata(5, 7, 9);
     * table.setdata(6, 6, 3); table.setdata(6, 7, 2); table.setdata(6, 9, 4);
     * table.setdata(7, 2, 4); table.setdata(7, 9, 2); table.setdata(8, 2, 8);
     * table.setdata(8, 5, 1); table.setdata(8, 6, 6); table.setdata(8, 9, 7);
     * table.setdata(9, 2, 2); table.setdata(9, 5, 4); table.setdata(9, 7, 1);
     *
     * SudokuFrame sf=new SudokuFrame(table);
     *
     * sf.pack(); sf.setVisible(true); while(!sf.isdone());
     * sf.setVisible(false); //sf=null; } *
     */

    /**
     * @return the running
     */
    /**
     * @param aRunning the running to set
     */
    public static void setRunning(int aRunning) {
        setRunning(aRunning);
    }

    /**
     * @return the running
     */
    public static boolean isRunning() {
        return running;
    }

    /**
     * @param aRunning the running to set
     */
    public static void setRunning(boolean aRunning) {
        running = aRunning;
    }

    /**
     * @return the sf
     */
    public static SudokuFrame getSf() {
        return sf;
    }
}

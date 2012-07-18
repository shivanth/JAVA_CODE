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
import utilities.MyTidyLogFormatter;

/**
 *
 * @author Shivanth
 */
public class Main {

    private static boolean running = true;
    private static SudokuFrame sf;
    static final Logger log = Logger.getLogger("MyLog");
    static final Logger log1 = Logger.getLogger("probLog");
    public static final Object lock = new Object();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here


        //getdata(maintable);

        FileHandler fh, fh1;

        try {
            // log = Logger.getLogger("MyLog");
            // This block configure the logger with handler and formatter  
            fh = new FileHandler("MyLogFile.log");
            log.addHandler(fh);
            log.setLevel(Level.ALL);
            fh1 = new FileHandler("Prob.log");
            log1.addHandler(fh1);
            log1.setLevel(Level.ALL);
            MyTidyLogFormatter formatter = new MyTidyLogFormatter();
            fh.setFormatter(formatter);
            fh1.setFormatter(formatter);

            // the following statement is used to log any messages  
            ProbTable.log = log;

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        sf = new SudokuFrame();
        getSf().pack();

        getSf().setVisible(true);



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



        int track = 0;
        int[] res = null;
        while (!done || isRunning()) {
            log1.info(maintable.toString());
            done = true;
            for (int i = 1; i < 10; i++) {
                log1.info("For table " + i + "\n" + prob[i].toString());
                if (prob[i].scan_table(maintable)) {
                    done = false;
                    log.info("Scan Table Success for " + i + " : " + ProbTable.getROW() + " " + ProbTable.getCOLUMN());
                    for (int j = 1; j < 10; j++) {
                        //log1.info("For table " + i + "\n" + prob[i].toString());
                        if (j == i) {


                            try {
                                log1.info("Changing ["+ProbTable.getROW()+","+ProbTable.getCOLUMN()+"] to "+i);
                                prob[i].kill_row(ProbTable.getROW());
                                prob[i].kill_column(ProbTable.getCOLUMN());
                                prob[i].kill_box(ProbTable.getROW(), ProbTable.getCOLUMN());
                                prob[i].writecell(ProbTable.getROW(), ProbTable.getCOLUMN(), ProbTable.GUESS_MAX);
                                maintable.setdata(ProbTable.getROW(), ProbTable.getCOLUMN(), i);

                                //System.out.print(maintable);
                                //System.out.println("");
                                //System.out.println("");

                            } catch (ErrorInTable ex) {
                                log.severe("Error in table");
                                //System.exit(1);
                            }
                            //prob[i].writecell(ProbTable.getROW(), ProbTable.getCOLUMN(), ProbTable.GUESS_MAX);
                            continue;
                        } else {
                            prob[j].killcell(ProbTable.getROW(), ProbTable.getCOLUMN());
                        }
                    }
                } else {
                    log.log(Level.INFO, "Scan table failed for {0}", i);
                }
            }
            if (done && isRunning()) {
                try {
                    //guessing logic goes here
                    
                    res = makeaguess(prob);
                    int row = res[0];
                    int col = res[1];
                    int index = res[2];
                    log1.info("Making guess for  ["+row+","+col+"] as "+index);
                    if(row==0||col==0 || index==0)
                        continue;
                    prob[index].kill_row(row);
                    prob[index].kill_column(col);
                    prob[index].kill_box(row, col);
                    prob[index].writecell(row, col, ProbTable.GUESS_MAX);
                    maintable.setdata(row, col, index);
                } catch (ErrorInTable ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    log.severe("Error in tabel immediately after guessing");
                }
                catch (Exception e ){
                    System.out.println(" "+res[0]+" "+res[1]+" "+res[2]);
                }

            }
            log.info(maintable.toString());
            log.log(Level.INFO, "Done:{0}" + " " + "IsRunning:{1}", new Object[]{done, isRunning()});
        }
        sf.display_results(maintable);

        synchronized (lock) {
            lock.notifyAll();
        }
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

    private static int[] makeaguess(ProbTable[] prob) {
        int a[] = new int[]{0, 0};
        int row = 0, col = 0, index = 0;
        int best[] = new int[]{0, 0};
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {

                a = prob[i].get_row_variance(j);
                if (a[0] > best[0]) {
                    best = a;
                    row = j;
                    col = a[1];
                    index = i;

                }
                a = prob[i].get_col_variance(j);
                if (a[0] > best[0]) {
                    best = a;
                    row = a[1];
                    col = j;
                    index = i;

                }
            }
        }
        return new int[]{row, col, index};
    }
}

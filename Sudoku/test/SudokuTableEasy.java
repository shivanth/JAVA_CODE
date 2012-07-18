/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;
import sudoku.Main;
import sudoku.SudokuRow;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import sudoku.ProbTable;
/**
 *
 * @author Shivanth
 */
public class SudokuTableEasy {
    SudokuRow [] SR;
    public SudokuTableEasy() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws IOException {
        
        Main.main(null);
        SR=Main.getSf().getPanel();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void Hard() throws InterruptedException{
        ProbTable.log.info("Hard");
        set_data(1, 5, 9);
        set_data(1, 7, 5);
        set_data(1, 8, 2);
        set_data(1, 9, 6);
        set_data(2, 7, 8);
        set_data(3, 2, 7);
        set_data(3, 5, 5);
        set_data(3, 8, 1);
        set_data(4, 1, 1);
        set_data(4, 2, 4);
        set_data(4, 6, 8);
        set_data(4, 8, 5);
        set_data(5, 2, 5);
        set_data(5, 4, 1);
        set_data(5, 6, 2);
        set_data(5, 8, 8);
        set_data(6, 2, 9);
        set_data(6, 4, 5);
        set_data(6, 8, 4);
        set_data(6, 9, 1);
        set_data(7, 2, 6);
        set_data(7, 5, 2);
        set_data(7, 8, 7);
        set_data(8, 3, 5);
        set_data(9, 1, 9);
        set_data(9, 2, 2);
        set_data(9, 3, 3);
        set_data(9, 5, 8);
        JButton jb=Main.getSf().getJButton();
      try {
            click(jb);
            //Main.getSf().actionPerformed(null);
        } catch (AWTException ex) {
            Logger.getLogger(SudokuTableEasy.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized(Main.lock){
        Main.lock.wait();
        }
    }
    
    
    /*
    @Test
            public void Easy() throws InterruptedException{
        ProbTable.log.info("Easy");
        set_data(1, 5, 9);
        set_data(1, 9, 7);
        set_data(2, 1, 9);
        set_data(2, 7, 5);
        set_data(2, 8, 8);
        set_data(2, 9, 1);
        set_data(3, 2, 6);
        set_data(3, 3, 8);
        set_data(3, 4, 5);
        set_data(3, 7, 3);
        set_data(3, 8, 2);
        set_data(4, 3, 1);
        set_data(4, 6, 5);
        set_data(5, 1, 3);
        set_data(5, 4, 9);
        set_data(5, 6, 2);
        set_data(5, 9, 8);
        set_data(6, 4, 1);
        set_data(6, 7, 2);
        set_data(7, 2, 3);
        set_data(7, 3, 9);
        set_data(7, 6, 8);
        set_data(7, 7, 4);
        set_data(7, 8, 5);
        set_data(8, 1, 7);
        set_data(8, 2, 8);
        set_data(8, 3, 2);
        set_data(8, 9, 6);
        set_data(9, 1, 5);
        set_data(9, 5, 1);
        JButton jb=Main.getSf().getJButton();
        try {
            click(jb);
            //Main.getSf().actionPerformed(null);
        } catch (AWTException ex) {
            Logger.getLogger(SudokuTableEasy.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized(Main.lock){
        Main.lock.wait();
        }
    }
    */
    void set_data(int row,int col,int data){
        SR[row-1].getBox(col-1).setText(""+(data));
    }
    private void click(JButton button) throws AWTException {
    Point point = button.getLocationOnScreen();
    Robot robot = new Robot();
    robot.setAutoWaitForIdle(true);
    robot.mouseMove(point.x + 10, point.y + 10);
    robot.mousePress(MouseEvent.BUTTON1_MASK);
    robot.mouseRelease(MouseEvent.BUTTON1_MASK);
  }
}


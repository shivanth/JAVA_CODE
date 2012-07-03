/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;
import sudoku.Main;
import sudoku.SudokuRow;

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
    public void Easy(){
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
        Main.getSf().getJButton().doClick();
        //Main.getSf().actionPerformed(null);
    }
    void set_data(int row,int col,int data){
        SR[row-1].getBox(col-1).setText(""+(data));
    }
}

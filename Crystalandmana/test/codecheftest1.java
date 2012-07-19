/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Shivanth
 */
public class codecheftest1 {
    
    public codecheftest1() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void test1(){
         String S = "3 10 1 1 1 5 5 5 10 10 10";
         ByteArrayInputStream b= new ByteArrayInputStream(S.getBytes());
         System.setIn(b);
         crystalandmana.CrystalAndMana.main(null);
    }
}

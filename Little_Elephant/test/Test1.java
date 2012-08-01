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
public class Test1 {
    
    public Test1() {
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
     public void test1() throws Exception {
         String S = "3\n3\n010\n5\n10001\n7\n0000000\n";
         ByteArrayInputStream b= new ByteArrayInputStream(S.getBytes());
         System.setIn(b);
         little_elephant.Little_Elephant.main(null);
         
         
     }
}

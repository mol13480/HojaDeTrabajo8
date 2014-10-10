/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015
 */

package hojadetrabajo8;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Irene
 */
public class SimpleSetTest {
    
    public SimpleSetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class SimpleSet.
     */
    @Test
    public void testGet() {
        //ArrayList<Word> base;
        //base = new ArrayList<Word>();
        
       // base.add(new Word("Casa","Sustativo"));
        
        Word word = new Word("casa","sustativo");
        SimpleSet instance = new SimpleSet();
        instance.add(word);
        Word word2 = instance.get(word);
        String expResult = word.getWord();
        Word result = instance.get(word);
        String result2 = result.getWord();
        System.out.println(result.getType());
        System.out.println(result.getWord());
        assertEquals(expResult, result2);
        
        
    }

    /**
     * Test of add method, of class SimpleSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Word wordObject = new Word ("Mesa","Sustativo");
        SimpleSet instance = new SimpleSet();
        instance.add(wordObject);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

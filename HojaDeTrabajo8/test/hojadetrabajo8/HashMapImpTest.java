/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015
 */

package hojadetrabajo8;

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
public class HashMapImpTest {
    
    public HashMapImpTest() {
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
     * Test of add method, of class HashMapImp.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Word W = new Word("fdjks","1");
        HashMapImp instance = new HashMapImp();
        instance.add(W);
        System.out.println(instance.get(W).getWord());
    }

    /**
     * Test of get method, of class HashMapImp.
     */
    @Test
    public void testGet() {
        System.out.println("get");
       
        HashMapImp instance = new HashMapImp();
        Word W = new Word("ruei","2");
       
        instance.add(W);
        System.out.println(instance.get(W).getWord());
    }
    
}

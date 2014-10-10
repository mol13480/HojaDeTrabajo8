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
public class TreeMapImpTest {
    
    public TreeMapImpTest() {
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
     * Test of add method, of class TreeMapImp.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Word W = new Word("asdf","1");
        TreeMapImp instance = new TreeMapImp();
        instance.add(W);
        System.out.println(instance.get(W).getWord());
        
    }

    /**
     * Test of get method, of class TreeMapImp.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Word W = new Word("fdsa","2");
        TreeMapImp instance = new TreeMapImp();
        instance.add(W);
        instance.add(new Word("asdg","e"));
        System.out.println(instance.get(W).getWord());
        System.out.println(instance.get(new Word("asdg","e")).getWord());
        
    }
    
}

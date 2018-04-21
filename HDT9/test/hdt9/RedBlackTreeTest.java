/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SergioMarchena
 */
public class RedBlackTreeTest {
    
    public RedBlackTreeTest() {
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
     * Test of size method, of class RedBlackTree.
     *
    @Test
    public void testSize() {
        System.out.println("size");
        RedBlackTree instance = new RedBlackTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of isEmpty method, of class RedBlackTree.
     *
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RedBlackTree instance = new RedBlackTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of get method, of class RedBlackTree.
     */
    @Test
    public void testGet() {
        System.out.println("Prueba para buscar un elemento en RBT");
        String key = "woman";
        RedBlackTree instance = new RedBlackTree();
        instance.put("woman","mujer");
        String expResult = "mujer";
        String result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult){
            fail("The test case is a prototype.");
        }
        else {
        System.out.println("PASO");
        }
        
    }

    /**
     * Test of contains method, of class RedBlackTree.
     *
    @Test
    public void testContains() {
        System.out.println("contains");
        String key = "";
        RedBlackTree instance = new RedBlackTree();
        boolean expResult = false;
        boolean result = instance.contains(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of put method, of class RedBlackTree.
     */
    @Test
    public void testPut() {
        System.out.println("Prueba para insertar un elemento en RBT");
        String key = "woman";
        String value = "mujer";
        RedBlackTree instance = new RedBlackTree();
        instance.put(key, value);
        String expResult = "mujer";
        String result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult){
            fail("The test case is a prototype.");
        }
        else {
        System.out.println("PASO");
        }
    }
   
    
    /**
     * Test of deleteMax method, of class RedBlackTree.
     *
    @Test
    public void testDeleteMax() {
        System.out.println("deleteMax");
        RedBlackTree instance = new RedBlackTree();
        instance.deleteMax();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of height method, of class RedBlackTree.
     *
    @Test
    public void testHeight() {
        System.out.println("height");
        RedBlackTree instance = new RedBlackTree();
        int expResult = 0;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}

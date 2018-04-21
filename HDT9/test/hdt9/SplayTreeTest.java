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
public class SplayTreeTest {
    
    public SplayTreeTest() {
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
     * Test of contains method, of class SplayTree.
     *
    @Test
    public void testContains() {
        System.out.println("contains");
        String key = "";
        SplayTree instance = new SplayTree();
        boolean expResult = false;
        boolean result = instance.contains(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * /

    /**
     * Test of get method, of class SplayTree.
     */
    @Test
    public void testGet() {
        System.out.println("Prueba para buscar un elemento en SPLAY");
        String key = "woman";
        SplayTree instance = new SplayTree();
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
     * Test of put method, of class SplayTree.
     */
    @Test
    public void testPut() {
        System.out.println("Prueba para insertar un elemento en SPLAY");
        String key = "woman";
        String value = "mujer";
        SplayTree instance = new SplayTree();
        instance.put(key, value);
        String expResult="mujer";
        String result = instance.get(key);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult){
            fail("The test case is a prototype.");
        }
        else {
        System.out.println("PASO");
        }
    }

    /**
     * Test of remove method, of class SplayTree.
     *
    @Test
    public void testRemove() {
        System.out.println("remove");
        String key = "";
        SplayTree instance = new SplayTree();
        instance.remove(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * /

    /**
     * Test of splaytree method, of class SplayTree.
     *
    @Test
    public void testSplaytree() {
        System.out.println("splaytree");
        Node nodo = null;
        String key = "";
        SplayTree instance = new SplayTree();
        Node expResult = null;
        Node result = instance.splaytree(nodo, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * /

    /**
     * Test of size method, of class SplayTree.
     */
//    @Test
//    public void testSize() {
//        System.out.println("size");
//        SplayTree instance = new SplayTree();
//        int expResult = 0;
//        int result = instance.size();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

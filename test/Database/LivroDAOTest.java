/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Database;

import Model.Livros;
import Database.LivroDAO;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Feh
 */
public class LivroDAOTest {
    
    public LivroDAOTest() {
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
     * Test of getLivros method, of class LivroDAO.
     */
    @Test
    public void testGetLivros() {
        System.out.println("getLivros");
        LivroDAO instance = new LivroDAO();
        List<Livros> listaLivros = new ArrayList<>();
        List<Livros> expResult = listaLivros;
        List<Livros> result = instance.getLivros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

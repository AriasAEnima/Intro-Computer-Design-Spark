package edu.escuelaing.arem.introSpark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.escuelaing.arep.introSpark.calculator.Calculator;
import static edu.escuelaing.arep.introSpark.calculator.Calculator.MEAN;
import edu.escuelaing.arep.introSpark.structures.LinkedListG;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static edu.escuelaing.arep.introSpark.calculator.Calculator.DEVIATION;
import edu.escuelaing.arep.introSpark.calculator.CalculatorException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author J. Eduardo Arias
 */
public class CalculadoraTest {
  
    private final Calculator.IntegerMath ADDITION = (a, b) -> a + b;
    private final Calculator.IntegerMath SUBTRACTION = (a, b) -> a - b;

    /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
   

    @Test
    public void enteros(){     
        try{
            System.out.println("40 + 2 = " +
            Calculator.operateBinary(40, 2, ADDITION));
            System.out.println("20 - 10 = " +
            Calculator.operateBinary(20, 10, SUBTRACTION));  
            assertTrue(true);
        }catch(Exception e){
            fail("Error");
        }
    }
    
    @Test
    public void Datos1() {
        try {
            List<Double> lista=new LinkedListG<Double>();
            lista.add(160.0);
            lista.add(591.0);
            lista.add(114.0);
            lista.add(229.0);
            lista.add(230.0);
            lista.add(270.0);
            lista.add(128.0);
            lista.add(1657.0);
            lista.add(624.0);
            lista.add(1503.0);
            Double ans1m=Calculator.operateList(lista, MEAN);
            Double ans2m=Calculator.operateList(lista, DEVIATION);
            assertEquals(550.6, ans1m,0.0001);
            assertEquals(572.03, ans2m,0.005);
        } catch (CalculatorException ex) {
            fail();
        }
    }
    
     @Test
    public void Datos2() {
        try {
            List<Double> lista=new LinkedListG<Double>();
            lista.add(15.0);
            lista.add(69.9);
            lista.add(6.5);
            lista.add(22.4);
            lista.add(28.4);
            lista.add(65.9);
            lista.add(19.4);
            lista.add(198.7);
            lista.add(38.8);
            lista.add(138.2);
            Double ans1m=Calculator.operateList(lista, MEAN);
            Double ans2m=Calculator.operateList(lista, DEVIATION);
            assertEquals(60.32, ans1m,0.0001);
            assertEquals(62.26, ans2m,0.005);
        } catch (CalculatorException ex) {
            fail();
        }
    }
    
    @Test
    public void Datos3(){
        try {
            List<Double> lista=new LinkedListG<Double>();
            lista.add(186.0);
            lista.add(699.0);
            lista.add(132.0);
            lista.add(272.0);
            lista.add(291.0);
            lista.add(331.0);
            lista.add(199.0);
            lista.add(1890.0);
            lista.add(788.0);
            lista.add(1601.0);
            Double ans1m=Calculator.operateList(lista, MEAN);
            Double ans2m=Calculator.operateList(lista, DEVIATION);
            assertEquals(638.9, ans1m,0.0001);
            assertEquals(625.633981, ans2m,0.00001);
        } catch (CalculatorException ex) {
            fail();
        }
    }

 
}

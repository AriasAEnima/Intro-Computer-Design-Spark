/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.introSpark.readers;

import edu.escuelaing.arep.introSpark.readers.StringReader;
import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author J. Eduardo Arias
 */
public class StringReaderTest {
    
    
       
    
    @Test
    public void canReadDataasString(){
        try {
            StringReader sr = new StringReader();
            sr.read("10 26 25 25");
            System.out.println(sr.getData());
        } catch (Exception e) {
            fail();
        }
    }
    
    
    @Test
    public void canGetElementsasDouble(){
        try {
            StringReader sr = new StringReader();
            sr.read("10 26 25 25");
            List<Double> data=sr.getData().get(0);
            System.out.println(data.get(0));
            System.out.println(data.get(1));
        } catch (Exception e) {
            System.out.println(e.toString());
            fail();
        }
    }
    
    
    
}

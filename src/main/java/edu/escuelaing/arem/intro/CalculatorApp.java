/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.intro;

import edu.escuelaing.arem.intro.readers.FileReaderColumns;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author J. Eduardo Arias
 */
public class CalculatorApp {
    public static void main(String[] args) throws Exception {                               
        Path file = Paths.get(args[0]);  
        FileReaderColumns frc=new FileReaderColumns(2);
        frc.read(file);
        List<List<Double>> data=frc.getData();
        int n=0;
        for (List<Double> col: data){
            Double m=Calculator.operateList(col, Calculator.MEAN);
            Double d=Calculator.operateList(col, Calculator.DESVIATION);
            System.out.println("Column "+n+" -> Mean : "+m+", Standard Deviation: "+d);   
            n++;
        }                      
    }
}

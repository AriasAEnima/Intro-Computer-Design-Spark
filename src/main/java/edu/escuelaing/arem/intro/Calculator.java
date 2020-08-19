/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.intro;

import java.util.List;

/**
 *
 * @author J. Eduardo Arias
 */
public class Calculator {
    
    public static final Calculator.DoubleMath MEAN=(a)->{
            Double ans=0.0;
            for(Double n:a){
                ans+=n;
            }
            return ans/a.size();
        };
        
    public static final Calculator.DoubleMath DESVIATION=(a)->{
            Double m=Calculator.operateList(a, MEAN);
            Double ans=0.0;
            for(Double n:a){
                ans+=Math.pow((n-m),2);
            }
            return Math.sqrt(ans/(a.size()-1));
        };
    
    public interface IntegerMath {
        int operation(int a, int b);        
    }
    
    /**
     * Permite hacer operaciones sobre una lista de double's.
     */
    public interface DoubleMath {
        double operation(List<Double> ld);
    }

    public  static int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    /**
     * Ejecuta una operacion sobre una lista de doubles.
     * @param a la lista
     * @param op la opracion
     * @return resultado de la operacion
     */
    public static double operateList(List<Double> a, DoubleMath op) {
        return op.operation(a);
    }
  

}

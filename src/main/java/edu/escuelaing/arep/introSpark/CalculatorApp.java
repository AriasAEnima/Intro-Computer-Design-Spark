/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.introSpark;

import edu.escuelaing.arep.introSpark.calculator.Calculator;
import edu.escuelaing.arep.introSpark.calculator.Calculator.DoubleMath;
import static edu.escuelaing.arep.introSpark.calculator.Calculator.MEAN;
import edu.escuelaing.arep.introSpark.readers.StringReader;
import edu.escuelaing.arep.introSpark.structures.LinkedListG;
import java.util.List;
import static spark.Spark.*;
import static edu.escuelaing.arep.introSpark.calculator.Calculator.DEVIATION;
import edu.escuelaing.arep.introSpark.calculator.CalculatorException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J. Eduardo Arias
 */
public class CalculatorApp {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/static");
        configureResponses();
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }

    private static void configureResponses() {
        get("/hello", (req, res) -> "Hello Heroku");
        post("/calcule", (req, res)
                  -> {
              res.status(200);
              res.type("application/json");
              List<Double> responsedata=calculateAInput(req.body(),new DoubleMath[]{MEAN,DEVIATION});
              if(responsedata!=null){
                  return "{\"mean\": \""+responsedata.get(0)+"\", \"deviation\":\""+responsedata.get(1)+"\"}";
              }else{
                  return "{\"mean\": null}";
              }
          });
    }
    
    private static List<Double> calculateAInput(String source,DoubleMath[] ops){
        StringReader sr = new StringReader();
        sr.read(source);

        List<Double> data = sr.getData().get(0);
        List<Double> ans = new LinkedListG<>();
        for (DoubleMath op : ops) {
            try {
                ans.add(Calculator.operateList(data, op));
            } catch (CalculatorException ex) {
                return null;
            }
        }        
        return ans;    
                
    }
}

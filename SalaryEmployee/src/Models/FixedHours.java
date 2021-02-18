/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;

/**
 *
 * @author Diana Molina Torres
 */
public class FixedHours {
    public static HashMap<String, Double> Week = new HashMap<>();
    public static HashMap<String, Double> Weekend = new HashMap<>();
    public static String[] hours = {"00:01-09:00", "09:01-18:00","18:01-00:00"};
    
    static{
        getPay();
    }
    
    public static void getPay(){
        Weekend.put("00:01-09:00",30.00);
        Weekend.put("09:01-18:00",20.0);
        Weekend.put("18:01-00:00",25.0);
        Week.put("00:01-09:00",25.0);
        Week.put("09:01-18:00",15.0);
        Week.put("18:01-00:00",20.0);
    }
}

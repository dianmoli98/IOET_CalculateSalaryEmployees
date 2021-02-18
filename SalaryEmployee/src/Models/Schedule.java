/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.time.LocalTime;
/**
 *
 * @author Diana Molina Torres
 */
public class Schedule {
    protected String dayWeek;
    protected LocalTime start;
    protected LocalTime end;
    
    public Schedule(String day, String start, String end){
        this.dayWeek= day;
        this.start = getTime(start);
        this.end = getTime(end);
    }

    public Schedule() {
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String day) {
        this.dayWeek = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public LocalTime getTime(String time){
        try{
            String[] hours = time.split(":");
            return LocalTime.of(Integer.parseInt(hours[0]), Integer.parseInt(hours[1]));
        } 
        catch (NumberFormatException ex) {
            System.out.println(ex);
            return null;
        }
    }  

}

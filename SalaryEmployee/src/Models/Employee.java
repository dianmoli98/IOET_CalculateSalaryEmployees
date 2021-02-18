/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
/**
 *
 * @author Diana Molina Torres
 */
public class Employee {
    protected String name;
    protected String lastName;
    protected float salary;
    protected ArrayList<Schedule> workSchedule;
    
    public Employee(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        this.workSchedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }

    public float getSalary() {
        return salary;
    }
    
    public ArrayList<Schedule> getSchedule(){
        return workSchedule;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setLastName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public void setSchedule(ArrayList<Schedule> schedule){
        this.workSchedule = schedule;
    }

    public void viewSalary(){
        System.out.println(" Employee:" + name + " " + lastName + " --- Salary to pay is: $ "+ salary);
    }
    
    
}

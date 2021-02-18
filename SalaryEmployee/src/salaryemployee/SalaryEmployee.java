/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salaryemployee;

import Models.Employee;
import Models.FixedHours;
import Models.Schedule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Diana Molina Torres
 */
public class SalaryEmployee {

    public HashMap<String, Double> Week = FixedHours.Week;
    public HashMap<String, Double> Weekend = FixedHours.Weekend;
    public String[] hours = FixedHours.hours;

    public ArrayList<Employee> viewEmployee(String inFilename) {
        ArrayList<Employee> employees = new ArrayList<>();
        try ( BufferedReader entry = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(inFilename)))) {
            String line = "";
            while ((line = entry.readLine()) != null) {
                String[] information = line.split("=");
                String employeeName = information[0];
                String[] information2 = employeeName.split(" ");
                Employee employee = new Employee(information2[0], information2[1]);

                String[] worked = information[1].split(",");
                for (String infoDays : worked) {
                    String[] hours = infoDays.split("-");
                    employee.getSchedule().add(new Schedule((hours[0].substring(0, 2)), (hours[0].substring(2)), hours[1]));
                }
                employees.add(employee);
            }
        } catch (IOException ex) {
            System.out.println("Excepcion Escritura y lectura de archivo: " + ex);
        }
        return employees;
    }
    
     public boolean isWeekend(String day) {
        return (day.equals("SA") || day.equals("SU"));
    }
    
    public boolean timeCorrectly(LocalTime start, LocalTime end, LocalTime employeeIn, LocalTime employeeOut) {
        if (employeeIn != null || employeeOut != null) {
        boolean startTime = employeeIn.equals(start)|| employeeIn.isAfter(start);
        boolean endTime = employeeOut.equals(end) || employeeOut.isBefore(end);
        if (end.getHour() == 0 && employeeOut.getHour() != 0) {
            endTime = employeeOut.getHour() == 24|| employeeOut.getHour() < 24;
        } else if (employeeOut.getHour() == 0) {
            endTime = employeeOut.equals(end);
        }
        return startTime && endTime;
        }
        else{
            return false;
        }
    }
    
    public void estimatePay(ArrayList<Employee> employees) {
        for (Employee emp : employees) {
            float salary = 0;
            String respectiveTime = "";
            for (Schedule time : emp.getSchedule()) {
                for (String timestamp : hours) {
                    String[] hours = timestamp.split("-");
                    LocalTime start = time.getTime(hours[0]);
                    LocalTime end = time.getTime(hours[1]);
                    if (timeCorrectly(start, end, time.getStart(), time.getEnd())) {
                        respectiveTime = timestamp;
                    }
                }
                salary += getDayAmount(respectiveTime, time);
            }
            emp.setSalary(salary);
            emp.viewSalary();
        }
    }

    public static void main(String[] args) {
        System.out.println("************************************************************");
        System.out.println("                     SALARY EMPLOYEES                       ");
        System.out.println("************************************************************");
        SalaryEmployee estimate = new SalaryEmployee();
        ArrayList<Employee> employees = estimate.viewEmployee("clientes.txt");
        estimate.estimatePay(employees);
        System.out.println("************************************************************");
    }

    public double getDayAmount(String respective, Schedule time) {
        if (respective != null || time.getStart() != null || time.getEnd() != null) {
            double amount;
            if (isWeekend(time.getDayWeek())) {
                amount = Weekend.get(respective);
            } else {
                amount = Week.get(respective);
            }
            Duration rest = Duration.between(time.getStart(), time.getEnd());
            double durationTime = time.getEnd().getHour() == 0 ? 24 - time.getStart().getHour() : (double) rest.toMinutes() / 60;
            return amount * durationTime;
        } else {
            return 0.0;
        }
    }

   


}

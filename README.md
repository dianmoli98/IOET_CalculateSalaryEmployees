# IOET_CalculateSalaryEmployees

#Description
This exercise consists of calculates the total that the company has to pay an employee, based on the hours  and the times during which they worked.

The project consists of two packages:
#Models: It has 3 classes:
    ##Employee - This class consists of first name, last name, salary, and list of the time the employee has worked.
    ##Schedule: This class consists of the information of an employee's work day, that is, it has the day, time of entry and exit of an employee.
    ##FixedHours: This class has the hours established by the company with their respective value to pay depending on the day.

#SalaryEmployee: It has two files:
  ##clients.txt: It is the txt file where various examples of clients can be found.
  ##SalaryEmployee: In this class the txt file is read and here you will find the various functions that are needed to be able to correctly estimate the salary to be paid.
  
#Functioning
The program reads the txt file named "customers.txt", from this it creates the Employee and Schedule objects. For each employee, the time is reviewed and the interval is obtained, the duration and the payment per day are calculated, and the salary to be paid by each employee is respectively calculated according to the time they have worked.

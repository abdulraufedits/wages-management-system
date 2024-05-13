
package wagesmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person{
    Scanner cin = new Scanner(System.in);
    private Salary managerSalary;
    private ArrayList<Employee> employees = new ArrayList();

    public Manager(String name, String id, long salary) {
        super(name, id);
        managerSalary = new ManagerSalary(salary);
    }
    
    public void addEmployee(Employee e){
        employees.add(e);
    }
    
    public Employee searchEmployee(String username){
        String search;
        boolean found = false;
        search = cin.nextLine();
        for(int i=0; i < employees.size(); i++){
            if(employees.get(i).getName() == search){
                found = true;
                System.out.println("Found!");
                return employees.get(i);
            }
        }
        if(found == false){
            System.out.println("Not found.");
        }
        return employees.get(0);
    }
    
    public void setEmployeeSalary(Employee emp, long salary){
        Salary empSalary = new EmployeeSalary(salary);
        boolean found = false;
        for(int i=0; i < employees.size(); i++){
            if(employees.get(i).getName() == emp.getName()){
                found = true;
                emp.setSalary(salary);
            }
        }
        if(found == false){
            System.out.println("Not found.");
        }
        
    }
       public long getSalary() {
        return managerSalary.getSalary();
    }
    
    public void setSalary(long salary){
        managerSalary.setSalary(salary);
    }
    @Override
    public String getName(){
        return super.getName();
    }
    
    
}

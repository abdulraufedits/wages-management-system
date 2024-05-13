
package wagesmanagementsystem;

import java.util.ArrayList;

public class Employee extends Person{
   private Salary empSalary;
   private ArrayList<Garment> garments = new ArrayList();

    public Employee(String name, String id, long salary) {
        super(name, id);
        
        empSalary = new EmployeeSalary(salary);
    }
   
   public void addGarment(Garment g) {
       garments.add(g);
   }
    public long getSalary() {
        return empSalary.getSalary()*garmentsSold();
    }
    
    public void setSalary(long salary){
        empSalary.setSalary(salary);
    }
    public int garmentsSold(){
        return garments.size();
    }
    @Override
    public String getName(){
        return super.getName();
    }
    
   
}


package wagesmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person{
    Scanner cin = new Scanner(System.in);
    private ArrayList<Manager> managers = new ArrayList();
    
    public Admin(String name, String id) {
        super(name, id);
    }
    public Manager searchManager(String username){
        String search;
        boolean found = false;
        search = cin.nextLine();
        for(int i=0; i < managers.size(); i++){
            if(managers.get(i).getName() == search){
                found = true;
                System.out.println("Found!");
                return managers.get(i);
            }
        }
        if(found == false){
            System.out.println("Not found.");
        }
        return managers.get(0);
    }
    
    public void setManagerSalary(Manager mng, long salary){
        Salary empSalary = new ManagerSalary(salary);
        boolean found = false;
        for(int i=0; i < managers.size(); i++){
            if(managers.get(i).getName() == mng.getName()){
                found = true;
                mng.setSalary(salary);
            }
        }
        if(found == false){
            System.out.println("Not found.");
        }
        
    }
    
}

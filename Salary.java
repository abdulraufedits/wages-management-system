
package wagesmanagementsystem;

import java.util.Scanner;

public abstract class Salary {
    Scanner cin = new Scanner(System.in);
    protected long salary;

    public Salary(long salary) {
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public void updateSalary(long oldSalary){
        long newSalary = cin.nextLong();
        oldSalary = newSalary;
    }
    
    
}

import java.util.ArrayList;
import java.util.List;

abstract class Employee{

    private String name;

    private int id;

    public Employee(String name,int id){//created a constructor for abstract class
        this.name = name;
        this.id = id;

    }

    public String getName(){//here encapsulation is used to check without accessing it
        return  name;

    }


    public int getId(){//encapsulation
        return id;
    }

    public abstract double calculateSalary();//we don't provide body for abstract method we declare it and leave it



    @Override//here Polymorphism is used where one method act different for all other
    public String toString(){//its a function in collection framework
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }

/*
 aligns the name to the left and reserves 15 spaces
  aligns the ID to the left and reserves 5 spaces.
   aligns the salary to the left, reserving 10 spaces and formatting it to two decimal points.
 */
//
//    @Override
//    public String toString() {
//        return String.format("| %-15s | %-5d | %-10.2f |", name, id, calculateSalary());
//    }
}

   class FullTimeEmployee extends  Employee{//here inheritance is used now since Employee is abstract class and has a abstract method you have to declare the method here

    private  double monthlySalary;


    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);//here super keyword is use to access the variable of constructor parent class
        this.monthlySalary = monthlySalary;
    }

    @Override
       public  double calculateSalary(){//here is declare the abstract method
        return monthlySalary;
    }

   }


   class PartTimeEmployee extends  Employee{

    private int hoursWorked;

    private  double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override//here we use polymorphism
       public  double calculateSalary(){
        return  hoursWorked * hourlyRate;
    }

   }



class PayrollSystem {
    private ArrayList<Employee> employeeList;//here we should arraylist to add as many variable and input unlike array which has a specific index


    public PayrollSystem() {
        employeeList = new ArrayList<>();//here is created a object of employee
    }


    public void addEmployee(Employee employee) {
        employeeList.add(employee);//function of arraylist
    }


    public void removeEmployee(int id) {
        Employee employeeToRemove = null;//created a variable name employeetoremove
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }


    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }


//
//    public void displayEmployee() {
//        if (employeeList.isEmpty()) {
//            System.out.println("No employees to display.");
//            return;
//        }
////
//        System.out.println("+-----------------+-------+------------+");
//        System.out.println("| Name            | ID    | Salary     |");
//        System.out.println("+-----------------+-------+------------+");
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }
//        System.out.println("+-----------------+-------+------------+");
//    }



        

    }
}


    public class Main {
        public static void main(String[] args) {
            PayrollSystem payrollSystem = new PayrollSystem();
            FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
            PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 40, 100);
            FullTimeEmployee emp3 = new FullTimeEmployee("Meena", 3, 80000);
            PartTimeEmployee emp4 = new PartTimeEmployee("Nina", 4, 20, 200);


            payrollSystem.addEmployee(emp1);
            payrollSystem.addEmployee(emp2);
            payrollSystem.addEmployee(emp3);
            payrollSystem.addEmployee(emp4);

            System.out.println("Initial Employee Details: ");
            payrollSystem.displayEmployee();

            System.out.println("Removing Employee");
            payrollSystem.removeEmployee(2);

            System.out.println("Remaining Employee Details: ");
            payrollSystem.displayEmployee();

        }
    }




/*
The `toString` method in Java is used to provide a **textual representation of an object**. By default, if you print an object or concatenate it with a string, Java calls the `toString` method of that object. Without overriding this method, the `toString` method from the `Object` class is used, which typically returns a string representation like `ClassName@HashCode`.

In your code, overriding the `toString` method allows you to display useful information about the `Employee` object instead of a cryptic output. Here’s how it helps:

1. **Readable Output:**
   The overridden `toString` method in your `Employee` class creates a human-readable format of the object's properties (name, id, and salary). For example:
   ```
   Employee[name=Vikas, id=1, salary=70000.0]
   ```

2. **Polymorphism in Action:**
   Since `toString` is overridden in the `Employee` class and inherited by its subclasses (`FullTimeEmployee` and `PartTimeEmployee`), calling `toString` on any `Employee` object—whether full-time or part-time—will generate appropriate output by invoking the same method.

3. **Convenience:**
   In your `displayEmployee` method, when you call `System.out.println(employee)`, Java implicitly calls the `toString` method of the `employee` object. This avoids needing a custom display method for every class.

Here's a breakdown of the overridden `toString` in your `Employee` class:
```java
@Override
public String toString() {
    return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
}
```
- **`name` and `id`:** Displays the name and ID of the employee.
- **`calculateSalary()`:** Dynamically computes the salary for both full-time and part-time employees, ensuring accurate and relevant details.

So, overriding `toString` makes your code cleaner, easier to maintain, and provides meaningful debugging and output-friendly representations. Without it, you'd only see an object's memory reference instead of useful details.

 */

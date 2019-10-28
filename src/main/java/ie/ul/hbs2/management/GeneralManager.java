package ie.ul.hbs2.management;

import java.util.*;

public class GeneralManager implements IEmployee {
    private String firstName;
    private String lastName;
    private int managementLevel = 2;
    private String password;
    private int wages;
    private List<Employee> employeeList = new ArrayList<>();

    public GeneralManager(String firstName, String lastName, String password, int wages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.wages = wages;
    }

    public void addEmployee(Employee e){
        employeeList.add(e);
    }

    public void removeEmployee(Employee e){
        employeeList.remove(e);
    }

    @Override
    public void showEmployeeDetails() {
        for (Employee e : employeeList){
            e.showEmployeeDetails();
        }
    }
}

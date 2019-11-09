package ie.ul.hbs2.management;

import java.util.*;

public class GeneralManager implements IEmployee {
    private String firstName;
    private String lastName;
    private int managementLevel = 2;
    private String password;
    private int wages;
    private List<IEmployee> employeeList = new ArrayList<>();

    public GeneralManager(String firstName, String lastName, String password, int wages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.wages = wages;
    }

    public void addEmployee(IEmployee e){
        if(e.getManagementLevel() > this.getManagementLevel()){
            employeeList.add(e);
        } else {
            System.out.println("Cannot add employee with higher management level to employee list.");
        }
    }

    public void removeEmployee(IEmployee e){
        employeeList.remove(e);
    }

    @Override
    public int accept(TotalWagesVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<IEmployee> accept(EmployeeListVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public int getWages() {
        return wages;
    }

    public int getManagementLevel() {
        return managementLevel;
    }

    public List<IEmployee> getEmployeeList() {
        return employeeList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

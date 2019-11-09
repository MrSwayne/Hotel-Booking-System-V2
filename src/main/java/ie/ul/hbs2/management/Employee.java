package ie.ul.hbs2.management;

import java.util.List;

public class Employee implements IEmployee {
    private String firstName;
    private String lastName;
    private int managementLevel = 3;
    private String password;
    private int wages;

    public Employee(String firstName, String lastName, String password, int wages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.wages = wages;
    }

    @Override
    public int accept(TotalWagesVisitor visitor) {
        return 0;
    }

    @Override
    public List<IEmployee> accept(EmployeeListVisitor visitor) {
        return null;
    }

    @Override
    public void addEmployee(IEmployee e) {

    }

    @Override
    public void removeEmployee(IEmployee e) {

    }

    public int getManagementLevel() {
        return managementLevel;
    }

    @Override
    public int getWages() {
        return wages;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

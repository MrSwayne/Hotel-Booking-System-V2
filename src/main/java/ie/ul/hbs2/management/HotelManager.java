package ie.ul.hbs2.management;

import java.util.ArrayList;
import java.util.List;

public class HotelManager implements IEmployee {
    private String firstName;
    private String lastName;
    private int managementLevel = 1;
    private String password;
    private int wages;
    private List<IEmployee> employeeList = new ArrayList<>();

    public HotelManager(String firstName, String lastName, String password, int wages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.wages = wages;
    }

    public void addEmployee(IEmployee e){
        employeeList.add(e);
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

    public int getManagementLevel() {
        return managementLevel;
    }

    public List<IEmployee> getEmployeeList() {
        return employeeList;
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

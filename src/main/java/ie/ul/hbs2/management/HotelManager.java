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

    public void addEmployee(Employee e){
        employeeList.add(e);
    }

    public void removeEmployee(Employee e){
        employeeList.remove(e);
    }

    @Override
    public void showEmployeeDetails() {
        for (IEmployee e : employeeList){
            e.showEmployeeDetails();
        }
    }
}

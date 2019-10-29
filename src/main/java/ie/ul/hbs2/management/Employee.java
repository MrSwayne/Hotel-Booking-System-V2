package ie.ul.hbs2.management;

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
    public void showEmployeeDetails() {
        System.out.println("Name: " + firstName + " " + lastName + "\nWages: " + wages);
    }
}

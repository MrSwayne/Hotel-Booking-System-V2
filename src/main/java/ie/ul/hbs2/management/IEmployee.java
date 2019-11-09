package ie.ul.hbs2.management;

import java.util.List;

public interface IEmployee {
    public int getWages();
    public int getManagementLevel();
    public String getFirstName();
    public String getLastName();
    public int accept(TotalWagesVisitor visitor);
    public List<IEmployee> accept(EmployeeListVisitor visitor);

    void addEmployee(IEmployee e);
    void removeEmployee(IEmployee e);
}

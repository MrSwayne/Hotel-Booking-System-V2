package ie.ul.hbs2.management;

import java.util.List;

public class EmployeeListVisitorImpl implements EmployeeListVisitor {
    @Override
    public List<IEmployee> visit(HotelManager hotelManager) {
        return hotelManager.getEmployeeList();
    }

    @Override
    public List<IEmployee> visit(GeneralManager generalManager) {
        return generalManager.getEmployeeList();
    }
}

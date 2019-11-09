package ie.ul.hbs2.management;

import java.util.List;

public interface EmployeeListVisitor {
    List<IEmployee> visit(HotelManager hotelManager);
    List<IEmployee> visit(GeneralManager generalManager);
}

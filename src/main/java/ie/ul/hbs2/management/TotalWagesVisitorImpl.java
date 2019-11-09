package ie.ul.hbs2.management;

public class TotalWagesVisitorImpl implements TotalWagesVisitor {
    @Override
    public int visit(HotelManager hotelManager) {
        int totalWages = 0;
        for (IEmployee e: hotelManager.getEmployeeList()){
            totalWages += e.getWages();
        }
        return totalWages;
    }

    @Override
    public int visit(GeneralManager generalManager) {
        int totalWages = 0;
        for (IEmployee e: generalManager.getEmployeeList()){
            totalWages += e.getWages();
        }
        return totalWages;
    }
}

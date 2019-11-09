package ie.ul.hbs2.management;

public interface TotalWagesVisitor {
    int visit(HotelManager hotelManager);
    int visit(GeneralManager generalManager);
}

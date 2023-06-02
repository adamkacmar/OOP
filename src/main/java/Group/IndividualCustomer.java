package Group;

import Schedule.TimeRange;

public class IndividualCustomer extends Customer{
    private String name;

    public IndividualCustomer() {
        super(0, null);
        this.name = null;
    }

    public IndividualCustomer(double budget, TimeRange timeRange, String name) {
        super(budget, timeRange);
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}

package Group;

import Schedule.TimeRange;

public class GroupCustomer extends Customer {
    int numberOfPeople;
    public GroupCustomer() {
        super(0, null);
        this.numberOfPeople = 0;
    }

    public GroupCustomer(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public GroupCustomer(double budget, int numberOfPeople, TimeRange timeRange) {
        super(budget, timeRange);
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}

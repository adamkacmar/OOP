package Group;

import Schedule.TimeRange;

public class FamilyCustomer extends GroupCustomer {
    private int numberOfChildren;
    private int numberOfParents;
    public FamilyCustomer() {
        super(0, 0, null);
        this.numberOfChildren = 0;
        this.numberOfParents = 0;
    }

    public FamilyCustomer(int numberOfParents, int numberOfChildren) {
        this.numberOfParents = numberOfParents;
        this.numberOfChildren = numberOfChildren;
        this.numberOfPeople = numberOfChildren + numberOfParents;
    }
    public FamilyCustomer(double budget, int numberOfPeople, TimeRange timeRange, int numberOfChildren) {
        super(budget, numberOfPeople, timeRange);
        this.numberOfChildren = numberOfChildren;
    }
    public int getNumberOfChildren(){
        return this.numberOfChildren;
    }
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }
    public int getNumberOfParents() {return this.numberOfPeople - this.numberOfChildren;
    }
}

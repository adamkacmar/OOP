package Group;

import Schedule.TimeRange;

public class CoupleCustomer extends GroupCustomer {
    private String coupleStatus;

    public CoupleCustomer() {
        super(0, 2, null);
        this.coupleStatus = null;
    }
    public CoupleCustomer(double budget, int numberOfPeople, TimeRange timeRange, String coupleStatus) {
        super(budget, numberOfPeople, timeRange);
        this.coupleStatus = coupleStatus;
    }
    public String getCoupleStatus() {
        return this.coupleStatus;
    }

}

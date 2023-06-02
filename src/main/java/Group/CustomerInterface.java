package Group;

import Schedule.TimeRange;

public interface CustomerInterface {
    double getBudget();
    int getMaxActivities();
    TimeRange getTimeRange();
    double calculatePrice(double basePrice);

}

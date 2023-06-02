package Schedule;

import Activity.Activity;
import Group.*;

import java.time.LocalTime;
import java.util.List;

/**
 * Trieda slúži na finálny objekt generovaného rozvrhu.
 */
public class Schedule {
    private Customer customer;
    private TimeRange timeRange;
    private List<Activity> chosenActivities;
    private double totalFee;

    public Schedule(ScheduleBuilder builder) {
        this.customer = builder.getCustomer();
        this.timeRange = builder.getTimeRange();
        this.chosenActivities = builder.getChosenActivities();
        this.totalFee = builder.getTotalFee();
    }

    public Customer getCustomer() {
        return customer;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public List<Activity> getChosenActivities() {
        return chosenActivities;
    }

    public double getTotalFee() {
        return totalFee;
    }
}
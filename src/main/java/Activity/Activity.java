package Activity;

import java.util.function.Predicate;

/**
 * Trieda slúži ako rodič hierarchie aktivít, ktoré sú generované v rozvrhu.
 */
public class Activity implements ActivityInterface {
    protected String activityTitle;
    protected int activityLength;
    protected String activityDescription;
    protected double activityFee;
    protected boolean individualFriendly;

    public Activity(String activityTitle, int activityLength, String activityDescription, double activityFee) {
        this.activityTitle = activityTitle;
        this.activityLength = activityLength;
        this.activityDescription = activityDescription;
        this.activityFee = activityFee;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public int getActivityLength() {
        return this.activityLength;
    }

    public String getActivityDescription() {
        return this.activityDescription;
    }

    public double getActivityFee() {
        return this.activityFee;
    }

    public String printInfo() {
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" + "Description: \n" + this.activityDescription);
    }

    public static Predicate<Activity> isFree() {
        return a -> a.activityFee == 0;
    }
}

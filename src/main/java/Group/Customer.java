package Group;

import Schedule.TimeRange;

/**
 * Trieda slúži ako rodič hierarchie zákazníkov, od ktorého závisí najmä finálna cena.
 */
public class Customer {
    private double budget;
    private TimeRange timeRange;

   public Customer(double budget, TimeRange timeRange) {
       this.budget = budget;
       this.timeRange = timeRange;
   }

    public Customer() {
       this.budget = 0;
       this.timeRange = null;
    }

    public double getBudget() {
       return this.budget;
   }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public double calculatePrice(double basePrice) {
        return basePrice;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void setTimeRange(TimeRange timeRange) { this.timeRange = timeRange; }
}

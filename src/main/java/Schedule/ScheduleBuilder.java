package Schedule;

import Activity.Activity;
import Group.*;
import Service.SeedService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Trieda funguje ako návrhový vzor Builder, ktorý postaví z rôznych časti finálny rozvrh typu Schedule.
 */
public class ScheduleBuilder {
    private Customer customer;
    private List<Activity> chosenActivities;
    private static final int ACTIVITY_FEE = 100;
    private TimeRange timeRange;
    private int totalDuration = 0;
    private double totalCost = 0;

    /**
     * Funkcia na pridanie aktivity podĽa vybranej kategórie do zoznamu.
     * @param selected
     * @return
     */
    public List<Activity> activityList(List<String> selected) {
        List<Activity> cuisineList = SeedService.getCuisineActivities();
        List<Activity> cultureList = SeedService.getCultureActivities();
        List<Activity> historyList = SeedService.getHistoryActivities();
        List<Activity> natureList = SeedService.getNatureActivities();
        List<Activity> sportList = SeedService.getSportActivities();

        List<Activity> finalList = new ArrayList<>();

        for (String category : selected) {
            switch (category) {
                case "Culture" -> {
                    if (!cultureList.isEmpty()) {
                        Collections.shuffle(cultureList);
                        finalList.add(cultureList.get(0));
                    }
                }
                case "Cuisine" -> {
                    if (!cuisineList.isEmpty()) {
                        Collections.shuffle(cuisineList);
                        finalList.add(cuisineList.get(0));
                    }
                }
                case "History" -> {
                    if (!historyList.isEmpty()) {
                        Collections.shuffle(historyList);
                        finalList.add(historyList.get(0));
                    }
                }
                case "Nature" -> {
                    if (!natureList.isEmpty()) {
                        Collections.shuffle(natureList);
                        finalList.add(natureList.get(0));
                    }
                }
                case "Sport" -> {
                    if (!sportList.isEmpty()) {
                        Collections.shuffle(sportList);
                        finalList.add(sportList.get(0));
                    }
                }
                default -> {
                    continue;
                }
            }
        }
        return finalList;
    }

    public ScheduleBuilder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public ScheduleBuilder setChosenActivites(List<Activity> chosenActivities) {
        this.chosenActivities = chosenActivities;
        return this;
    }

    /**
     * Builder rozvrhu.
     * @return
     */
    public Schedule build() {
        double budget = customer.getBudget();
        setTotalCost(0);
        setTotalDuration(0);
        for (Activity activity : chosenActivities) {
            totalDuration += activity.getActivityLength();
        }
        if (totalDuration > customer.getTimeRange().getDuration()) {
            throw new IllegalArgumentException("The total duration of chosen activities exceeds the time range.");
        }

        for (Activity activity : chosenActivities) {
            if (customer instanceof FamilyCustomer) {
                totalCost += (activity.getActivityFee()*((FamilyCustomer) customer).getNumberOfParents() + activity.getActivityFee()*((FamilyCustomer) customer).getNumberOfChildren()*0.5);
            }
            else if (customer instanceof CoupleCustomer) {
                totalCost += (activity.getActivityFee()*2);
            }
            else if (customer instanceof GroupCustomer) {
                totalCost += (activity.getActivityFee()*((GroupCustomer) customer).getNumberOfPeople());
            }
            else {
                totalCost += activity.getActivityFee();

            }
        }

        if (totalCost > budget) {
            throw new IllegalArgumentException("The total cost of chosen activities exceeds the customer's budget.");
        }

        return new Schedule(this);
    }

    public Customer getCustomer() { return this.customer; }
    public TimeRange getTimeRange() { return this.timeRange;}

    public List<Activity> getChosenActivities() { return this.chosenActivities; }

    public double getTotalCost() {
        return totalCost;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public double getTotalFee() {
        return this.totalCost;
    }
}
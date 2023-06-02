package Activity;

public class HistoryActivity extends Activity {
    private String historyType;

    public HistoryActivity(String activityTitle, int activityLength, String activityDescription, double activityFee, String historyType) {
        super(activityTitle, activityLength, activityDescription, activityFee);
        this.historyType = historyType;
    }

    @Override
    public int getActivityLength() {
        return super.getActivityLength();
    }

    @Override
    public String getActivityDescription() {
        return super.getActivityDescription();
    }

    @Override
    public double getActivityFee() {
        return super.getActivityFee();
    }

    @Override
    public String getActivityTitle() {
        return super.getActivityTitle();
    }

    @Override
    public String printInfo() {
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" + "Description: \n" +
                this.activityDescription + "\nCost: " + this.activityFee + "\nHistorical Monument: " + this.historyType);


    }

    public String getHistoryType() {
        return this.historyType;
    }
}

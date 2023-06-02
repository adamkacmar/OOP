package Activity;

public class CultureActivity extends Activity implements ActivityInterface {
    private String cultureType;
    public CultureActivity(String activityTitle, int activityLength, String activityDescription, double activityFee, String cultureType) {
        super(activityTitle, activityLength, activityDescription, activityFee);
        this.cultureType = cultureType;
    }

    public String getCultureType() {
        return this.cultureType;
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
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" + "Description: \n" + this.activityDescription + "\nCost: " + this.activityFee + "\nType: " + this.cultureType);

    }
}

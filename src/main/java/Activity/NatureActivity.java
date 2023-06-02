package Activity;
public class NatureActivity extends Activity implements ActivityInterface {
    private String terrain;
    public NatureActivity(String activityTitle, int activityLength, String activityDescription, double activityFee, String terrain) {
        super(activityTitle, activityLength, activityDescription, activityFee);
        this.terrain = terrain;
    }
    public String getTerrain() {
        return this.terrain;
    }

    @Override
    public String getActivityTitle() {
        return super.getActivityTitle();
    }

    @Override
    public double getActivityFee() {
        return super.getActivityFee();
    }

    @Override
    public String getActivityDescription() {
        return super.getActivityDescription();
    }

    @Override
    public int getActivityLength() {
        return super.getActivityLength();
    }

    @Override
    public String printInfo() {
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" +
                "Terrain: " + this.terrain + "\nDescription: \n" + this.activityDescription);
    }
}
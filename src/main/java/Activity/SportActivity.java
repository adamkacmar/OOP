package Activity;
public class SportActivity extends Activity implements ActivityInterface {
    private String sportType;
    private String equipmentRequired;

    public SportActivity(String activityTitle, int activityLength, String activityDescription, double activityFee, String sportType, String equipmentRequired) {
        super(activityTitle, activityLength, activityDescription, activityFee);
        this.sportType = sportType;
        this.equipmentRequired = equipmentRequired;
    }

    public String getSportType() {
        return this.sportType;
    }
    public String getEquipmentRequired() {
        return this.equipmentRequired;
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
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" +
                "Sport: " + this.sportType + "\nEquipment: " + this.equipmentRequired +
                "\nDescription: \n" + this.activityDescription);
    }
}
package Activity;

public class CuisineActivity extends Activity implements ActivityInterface {
    private String typeOfFood;
    private String cuisine;

    public CuisineActivity(String activityTitle, int activityLength, String activityDescription, double activityFee, String typeOfFood, String cuisine) {
        super(activityTitle, activityLength, activityDescription, activityFee);
        this.typeOfFood = typeOfFood;
        this.cuisine = cuisine;
    }

    @Override
    public double getActivityFee() {
        return super.getActivityFee();
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
    public String getActivityTitle() {
        return super.getActivityTitle();
    }

    @Override
    public String printInfo() {
        return (this.activityTitle + " - " + this.activityLength + " minutes\n" + "Description: \n" + this.activityDescription + "\nCost: " + this.activityFee + "\nCuisine: " + this.cuisine + "Recommended food: " + this.typeOfFood);
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

}


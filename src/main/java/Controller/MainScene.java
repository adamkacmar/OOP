package Controller;

import Activity.Activity;
import Group.*;
import Schedule.*;
import Schedule.TimeRange;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Hlavná scéna GUI.
 */
public class MainScene implements Initializable {
    @FXML
    public Label scheduleTextArea;
    @FXML
    public TextField budgetInput;
    @FXML
    public Button generateScheduleButton;
    @FXML
    public Spinner<Integer> startTime = new Spinner<>();
    @FXML
    public Spinner<Integer> endTime = new Spinner<>();

    @FXML
    private RadioButton soloButton;

    @FXML
    private RadioButton friendButton;

    @FXML
    private RadioButton familyButton;

    @FXML
    private RadioButton coupleButton;

    @FXML
    private CheckBox cultureCheck;
    @FXML
    private CheckBox natureCheck;
    @FXML
    private CheckBox sportCheck;
    @FXML
    private CheckBox cuisineCheck;
    @FXML
    private CheckBox historyCheck;
    @FXML
    private TextField peopleInput;
    @FXML
    private TextField parentsInput;
    @FXML
    private TextField childrenInput;
    @FXML
    private Label finalScheduleLabel;

    private CheckBox[] activityCategories;

    private List<String> selectedCategories = new ArrayList<>();

    ToggleGroup customerTypeToggle = new ToggleGroup();

    Customer customer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            SpinnerValueFactory<Integer> valueFactoryStart = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12);
            SpinnerValueFactory<Integer> valueFactoryEnd = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12);

            startTime.setValueFactory(valueFactoryStart);
            endTime.setValueFactory(valueFactoryEnd);

            soloButton.setToggleGroup(customerTypeToggle);
            friendButton.setToggleGroup(customerTypeToggle);
            familyButton.setToggleGroup(customerTypeToggle);
            coupleButton.setToggleGroup(customerTypeToggle);
        });
    }

    /**
     * Reakcia tlačidla na generovanie rozvrhu.
     * @param event
     * @throws IOException
     */
    public void generateScheduleButtonClicked(ActionEvent event) throws IOException {
        Integer startHour = startTime.getValue();
        Integer endHour = endTime.getValue();

        finalScheduleLabel.setText("");

        if ((startHour != null && endHour != null) && endHour > startHour) {
            String budgetString = budgetInput.getText();
            TimeRange timeRange = new TimeRange(startHour, endHour);
            if (!budgetString.isEmpty()) {
                double budget = Double.parseDouble(budgetString);
                if (customerTypeToggle.getSelectedToggle() == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a customer type.");
                    alert.showAndWait();
                    return;
                }
                else {
                    if (soloButton.isSelected()) {
                        customer = new IndividualCustomer();
                    }
                    else if (friendButton.isSelected()) {
                        String groupString = peopleInput.getText();
                        if (!groupString.isEmpty()) {
                            int groupNumber = Integer.parseInt(groupString);
                            customer = new GroupCustomer(groupNumber);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter the number of people in group.");
                            alert.showAndWait();
                        }
                    }
                    else if (familyButton.isSelected()) {
                        String parentsString = parentsInput.getText();
                        String childrenString = childrenInput.getText();

                        if (!parentsString.isEmpty() && !childrenString.isEmpty()) {
                            int parentsNumber = Integer.parseInt(parentsString);
                            int childrenNumber = Integer.parseInt(childrenString);
                            customer = new FamilyCustomer(parentsNumber, childrenNumber);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter the number of people in group.");
                            alert.showAndWait();
                        }
                    }
                    else {
                        customer = new CoupleCustomer();
                    }
                }

                customer.setBudget(budget);
                customer.setTimeRange(timeRange);

                if (!cultureCheck.isSelected() && !natureCheck.isSelected() && !sportCheck.isSelected() && !cuisineCheck.isSelected() && !historyCheck.isSelected()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please select at least one activity category.");
                    alert.showAndWait();
                    return;
                }
                else {
                    if (cultureCheck.isSelected()) {
                        selectedCategories.add("Culture");
                    }
                    if (natureCheck.isSelected()) {
                        selectedCategories.add("Nature");
                    }
                    if (sportCheck.isSelected()) {
                        selectedCategories.add("Sport");
                    }
                    if (cuisineCheck.isSelected()) {
                        selectedCategories.add("Cuisine");
                    }
                    if (historyCheck.isSelected()) {
                        selectedCategories.add("History");
                    }
                }

                ScheduleBuilder scheduleBuilder = new ScheduleBuilder();
                List<Activity> finalActivities = scheduleBuilder.activityList(selectedCategories);
                scheduleBuilder.setChosenActivites(finalActivities);
                scheduleBuilder.setCustomer(customer);

                Schedule schedule = scheduleBuilder.build();

                for (Activity activity : schedule.getChosenActivities()) {
                    finalScheduleLabel.setText(finalScheduleLabel.getText() + activity.printInfo() + "\n");
                }

                finalScheduleLabel.setText(finalScheduleLabel.getText() + "\n\n" + schedule.getTotalFee() + "€");
                finalActivities.clear();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a budget.");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "End value is smaller than Start value.");
            alert.showAndWait();
        }
    }
}

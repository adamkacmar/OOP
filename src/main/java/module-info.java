module BratislavaGo {
    requires javafx.controls;
    requires javafx.fxml;


    opens Controller to javafx.fxml;
    exports Controller;
    exports Activity;
    exports Group;
    exports Schedule;
    exports Service;
    exports User;
}
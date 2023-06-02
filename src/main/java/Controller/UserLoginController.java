package Controller;

import User.LoginException;
import User.UserLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller pre scénu prihlasovania.
 */
public class UserLoginController {
    @FXML
    public Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginStatus;

    private UserLogin userLogin = new UserLogin();

    public void loginButtonClicked(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            if (userLogin.isValidLogin(username, password)) {
                loginStatus.setText("Login successful!");
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
                Parent root = loader.load();
                root.setStyle("-fx-background-color: #FDF7DE;");

                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            } else {
                throw new LoginException("Invalid.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (LoginException le) {
            loginStatus.setText("Login Error: " + le.getMessage());
        }
    }
}

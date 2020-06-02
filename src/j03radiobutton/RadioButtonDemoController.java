package j03radiobutton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RadioButtonDemoController {
    @FXML private RadioButton rbPython, rbC, rbCpp, rbJava;
    @FXML private ImageView img;
    @FXML private Label resultLabel;

    // Radio buttons must be configured into a group.
    // Only one of the buttons in the group can be selected at any time.
    // A button group is created by the ToggleGroup class.
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        // ToggleGroup provides only a default constructor.
        toggleGroup = new ToggleGroup();

        // Radio buttons are added to the toggle group by calling setToggleGroup() on the button.
        rbPython.setToggleGroup(toggleGroup);
        rbC.setToggleGroup(toggleGroup);
        rbCpp.setToggleGroup(toggleGroup);
        rbJava.setToggleGroup(toggleGroup);

        img.setImage(new Image("images/qmark.png"));
        img.setFitHeight(100);
        img.setPreserveRatio(true);

        // Watch for changes in a toggle group
        // register a ChangeListener on the toggle group.
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue;
                switch (rb.getText()) {
                    case "Python":
                        img.setImage(new Image("images/pylang.jpg"));
                        break;
                    case "C":
                        img.setImage(new Image("images/clang.png"));
                        break;
                    case "C++":
                        img.setImage(new Image("images/cpplang.png"));
                        break;
                    case "Java":
                        img.setImage(new Image("images/logo.png"));
                        break;
                    default:
                        img.setImage(new Image("images/qmark.png"));
                }
            }
        });
    }

    @FXML public void handleSubmitButton(ActionEvent event) {
        String result = "<none>";

        // Obtain the selected radio button in a toggle group
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
        if (rb != null) {
            result = rb.getText();
        }

        resultLabel.setText("You choose " + result + " for your favorite langauge.");
    }
}

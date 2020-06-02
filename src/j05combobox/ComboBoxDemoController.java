package j05combobox;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ComboBoxDemoController {
    @FXML private ImageView image;

    // An empty combo box
    @FXML private ComboBox<String> comboBox;

    @FXML private Button chooseButton;
    @FXML private Label result;

    // A list of the items that will be displayed in combo box.
    // It is an object of type ObservableList (a list of observable objects)
    private ObservableList<String> languages;

    @FXML
    public void initialize() {
        // An easy way to create an ObservableList is to use the factory method observableArrayList(),
        // observableArrayList() is a static method defined by the FXCollections class.
        languages = FXCollections.observableArrayList("Python", "C", "C++", "Java");

        // set ObservableList into combo box
        comboBox.setItems(languages);

        defaultOption();
        result.setText("");

        // ComboBox ChangeListener
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showOption(newValue);
            }
        });
    }

    private void defaultOption() {
        // set default selected item in combo box
        comboBox.setValue("Python");

        showOption("Python");
    }

    private void showOption(String selected) {
        String resource = "qmark.png";
        switch (selected) {
            case "Python": resource = "pylang.jpg"; break;
            case "C": resource = "clang.png"; break;
            case "C++": resource = "cpplang.png"; break;
            case "Java": resource = "logo.png"; break;
        }
        image.setImage(new Image("images/" + resource));
        chooseButton.setText("Choose " + selected);
    }

    @FXML
    public void handleChooseButton(ActionEvent event) {
        // obtaining ComboBox item with getValue()
        result.setText("You choose " + comboBox.getValue());
    }
}

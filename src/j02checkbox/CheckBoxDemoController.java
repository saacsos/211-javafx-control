package j02checkbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class CheckBoxDemoController {
    // VBox fx:id `container`
    @FXML private VBox container;

    // Checkbox fx:id `termsOfUseCheckBox`
    @FXML private CheckBox termsOfUseCheckBox;

    // Label fx:id `label1`
    @FXML private Label label1;

    // These control are not in fxml
    private HBox selectArea;
    private CheckBox cbLinux, cbMac, cbWindows;
    private Label resultLabel;
    private Button button;

    @FXML
    public void initialize() {
        // change alignment of container
        container.setAlignment(Pos.CENTER);
        label1.setText("Terms of use is not selected");

        // construct CheckBox objects with text
        cbLinux = new CheckBox("Linux");
        cbMac = new CheckBox("Mac");
        cbWindows = new CheckBox("Windows");

        // construct Button object with text
        button = new Button("Submit");

        // set event on mouse clicked
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showResult();
            }
        });

        selectArea = new HBox();

        // add all 3 checkboxes into HBox `selectArea`
        selectArea.getChildren().addAll(cbLinux, cbWindows, cbMac);
        selectArea.setAlignment(Pos.CENTER);

        resultLabel = new Label("OS used: <none>");

        container.getChildren().add(new Text("Which OS have you ever used?"));
        container.getChildren().add(selectArea);
        container.getChildren().add(button);
        container.getChildren().add(resultLabel);
    }

    @FXML
    public void handleTermsOfUseCheckBox(ActionEvent event) {
        if (termsOfUseCheckBox.isSelected()) {
            label1.setText("You accept Terms of use");
            label1.setTextFill(Color.rgb(0, 0, 255));
        } else {
            label1.setText("Terms of use is not selected");
            label1.setTextFill(Color.rgb(255, 0, 0));
        }
    }

    private void showResult() {
        ArrayList<String> result = new ArrayList<>();
        if (cbLinux.isSelected()) {
            result.add("Linux");
        }
        if (cbMac.isSelected()) {
            result.add("Mac");
        }
        if (cbWindows.isSelected()) {
            result.add("Windows");
        }
        if (result.isEmpty()) {
            resultLabel = new Label("OS used: <none>");
        } else {
            resultLabel.setText("OS used: " + result);
        }
    }
}

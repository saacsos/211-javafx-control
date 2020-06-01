package j01button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ButtonDemoController {
    // VBox fx:id `container`
    @FXML private VBox container;

    // Button fx:id `btn`
    @FXML private Button btn;

    // Label `label` ไม่ได้กำหนดใน fxml
    private Label label;

    // Button `imgBtn` ไม่ได้กำหนดใน fxml
    private Button imgBtn;

    // ImageView `logo` ไม่ได้กำหนดใน fxml
    private ImageView logo;

    // ImageView `logoFx` ไม่ได้กำหนดใน fxml
    private ImageView logoFx;

    // model Counter
    private Counter counter = new Counter();

    @FXML
    public void initialize() {
        // construct object Label and set text of label
        label = new Label();
        label.setText("Click button");

        // change alignment of container
        container.setAlignment(Pos.CENTER);

        // add label to container
        container.getChildren().add(label);

        // set minimum width of btn
        btn.setMinWidth(200);

        // construct object ImageView
        logo = new ImageView("/images/logo.png");
        // set width of image
        logo.setFitWidth(60);
        // preserve image ratio
        logo.setPreserveRatio(true);

        // construct another object ImageView
        logoFx = new ImageView("/images/javafx-1.png");
        logoFx.setFitWidth(60);
        logoFx.setPreserveRatio(true);

        // construct imgBtn with text and image in button
        imgBtn = new Button("Java", logo);
        // set position in button to show image
        imgBtn.setContentDisplay(ContentDisplay.TOP);

        // set event on mouse clicked
        imgBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgBtn.getContentDisplay() == ContentDisplay.TOP) {
                    changeImageButton(ContentDisplay.BOTTOM, logoFx, "JavaFX");
                } else {
                    changeImageButton(ContentDisplay.TOP, logo, "Java");
                }
                label.setText("Image button was pressed");
            }
        });

        // add imgBtn to container
        container.getChildren().add(imgBtn);
    }

    @FXML
    public void handleButton(ActionEvent event) {
        // call method of model counter
        counter.increase();

        // display value
        label.setText("Button has been clicked: " + counter.getValue());
    }

    private void changeImageButton(ContentDisplay display, ImageView imageView, String text) {
        imgBtn.setContentDisplay(display);
        // set new image of button
        imgBtn.setGraphic(imageView);
        imgBtn.setText(text);
    }


}

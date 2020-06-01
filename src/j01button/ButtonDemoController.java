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
    @FXML private VBox container;
    @FXML private Button btn;
    private Label label;
    private Button imgBtn;

    private int counter = 0;

    @FXML
    public void initialize() {
        label = new Label();
        label.setText("Click button");

        container.setAlignment(Pos.CENTER);
        container.getChildren().add(label);

        btn.setMinWidth(200);

        ImageView logo = new ImageView("/images/logo.png");
        logo.setFitWidth(60);
        logo.setPreserveRatio(true);
        imgBtn = new Button("Java", logo);
        imgBtn.setContentDisplay(ContentDisplay.TOP);
        imgBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (imgBtn.getContentDisplay() == ContentDisplay.TOP) {
                    imgBtn.setContentDisplay(ContentDisplay.BOTTOM);
                } else {
                    imgBtn.setContentDisplay(ContentDisplay.TOP);
                }

            }
        });
        container.getChildren().add(imgBtn);
    }

    @FXML
    public void handleButton(ActionEvent event) {
        label.setText("Button has been clicked: " + ++counter);
    }




}

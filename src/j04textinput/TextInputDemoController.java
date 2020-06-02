package j04textinput;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TextInputDemoController {
    @FXML
    private TextField input1, inputPassword, input3, input4;
    @FXML
    private TextArea inputTextArea;

    @FXML
    private Label result1, result2, result3;

    @FXML
    public void initialize() {
        // set prompt text to text field
        input3.setPromptText("Integer only");

        // read only text field
        input4.setEditable(false);

        // set data in text field
        input4.setText("Read ONLY");

        // create a tooltip for text field
        Tooltip tip = new Tooltip();
        tip.setText("this field cannot be edited");
        input4.setTooltip(tip);

        result1.setText("");
        result2.setText("");
        result3.setText("");
    }

    @FXML
    public void handleSubmitButton(ActionEvent event) {
        // get user input from text field
        String s1 = input1.getText();
        result1.setText(s1);

        // get user input from password field
        String password = inputPassword.getText();
        result2.setText(password);

        String s3 = "";

        try {
            int number = Integer.parseInt(input3.getText());
            s3 = "" + (number + 1);

            // get user input from text area
            String stringArea = inputTextArea.getText();
            s3 += "\n\n" + stringArea;

            // clear user input
            input1.clear();
            inputPassword.clear();
            input3.clear();
            inputTextArea.clear();
        } catch (NumberFormatException e) {
            // create alert dialog to warn user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Number Format");
            alert.setHeaderText("Invalid Number Format for input with prompt");
            alert.setContentText("Integer is required in this field");
            alert.show();
        }

        result3.setText(s3);
    }
}

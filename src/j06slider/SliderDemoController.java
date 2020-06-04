package j06slider;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderDemoController {
    @FXML private Slider vSlider, hSlider;
    @FXML private Label vLabel, hLabel;

    @FXML
    public void initialize() {
        // Tick marks are off by default.
        vSlider.setShowTickMarks(true);

        // Show labels (values) into a slider.
        vSlider.setShowTickLabels(true);

        // Set maximum value of slider.
        vSlider.setMax(10.0);

        // Set minimum value of slider.
        vSlider.setMin(0.0);

        // Control how far the slider moves each time its position is changed
        // by pressing an arrow key on the keyboard by setting the block increment.
        vSlider.setBlockIncrement(1.0);

        // After the slider is dragged to a new setting, its value is automatically
        // adjusted to equal that of the nearest tick mark.
        vSlider.setSnapToTicks(true);

        // Set the major tick mark units.
        vSlider.setMajorTickUnit(5);

        // Set the minor tick mark spacing.
        vSlider.setMinorTickCount(4);

        // Observe changes to the value of a slider by registering a change listener
        // on the slider's value property.
        vSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Obtain the current value of the slider by calling getValue()
                vLabel.setText( String.format("%.2f", vSlider.getValue()) );
            }
        });

        hSlider.setMin(0);
        hSlider.setMax(100);
        hSlider.setBlockIncrement(20);
        hSlider.setMinorTickCount(1);
        hSlider.setMajorTickUnit(20);
        hSlider.setShowTickMarks(true);
        hSlider.setShowTickLabels(true);
        hSlider.setSnapToTicks(false);

        hSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                hLabel.setText(String.format("%.2f", newValue));
            }
        });

    }
}

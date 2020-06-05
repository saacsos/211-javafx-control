package j07tableview;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewDemoController {
    @FXML private TableView<ProjectEntity> projectTableView;
    @FXML private Label selectedIndexLabel;
    @FXML private Label result;

    private ObservableList<ProjectEntity> projectEntities;

    @FXML
    public void initialize() {

        // 1. Create an ObservableList of the data to be displayed in the table.
        // One way to do this is to use FXCollections.observableArrayList().
        projectEntities = FXCollections.observableArrayList(
                new ProjectEntity("John", "myapp.audio", "Completed", 14023),
                new ProjectEntity("Adam", "myapp.video", "On Schedule", 33027),
                new ProjectEntity("Rachel", "myapp.filter", "Delayed", 184129),
                new ProjectEntity("Michael", "myapp.database", "Completed", 67412)
        );
        projectEntities.add(new ProjectEntity("Chris", "myapp.archive", "In Testing", 117454));

        // 2. Passing in the list of items to display.
        projectTableView.setItems(projectEntities);

        // 3. Define a TableColumn instance for each column in the table, specifying the name of the column.
        // Add headings and specify cell factories.
        TableColumn<ProjectEntity, String> programName = new TableColumn<>("Programmer");
        TableColumn<ProjectEntity, String> packName = new TableColumn<>("Package Name");
        TableColumn<ProjectEntity, String> status = new TableColumn<>("Status");
        TableColumn<ProjectEntity, Integer> size = new TableColumn<>("Size");

        // 4. Set the cell factory for each TableColumn.
        programName.setCellValueFactory(new PropertyValueFactory<>("programmer"));
        packName.setCellValueFactory(new PropertyValueFactory<>("packageName"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));

        // 5. Add each column to the TableView instance.
        projectTableView.getColumns().add(programName);
        projectTableView.getColumns().add(packName);
        projectTableView.getColumns().add(status);
        projectTableView.getColumns().add(size);

        // Size the table view.
        projectTableView.setPrefHeight(200);

        // Get the TableView selection model.
        TableView.TableViewSelectionModel<ProjectEntity> selectionModel = projectTableView.getSelectionModel();

        // Use a change listener to respond to a change of selection within the table view
        selectionModel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Display the index of the selection.
                selectedIndexLabel.setText(String.valueOf(newValue));
                result.setText("Package Name: " + projectEntities.get(newValue.intValue()).getPackageName());
            }
        });

    }
}

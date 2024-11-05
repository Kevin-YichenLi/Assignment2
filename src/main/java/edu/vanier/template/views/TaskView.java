package edu.vanier.template.views;

import edu.vanier.template.controllers.TaskController;
import edu.vanier.template.models.Task;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class TaskView extends VBox {
    private final ArrayList<Task> tasks;
    private final TaskController controller = new TaskController();
    private TableView<Task> table;

    public TaskView(ArrayList<Task> tasks) {
        this.tasks = tasks;

        this.getChildren().addAll(createComboBox(), createTable());
        this.setSpacing(50);
    }

    private Region createTable() {
        table = new TableView<>();
        table.setPlaceholder(new Label("Nothing to display"));

        TableColumn<Task, Integer> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Task, String> taskNameColumn = new TableColumn<>("Task Name");
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));

        TableColumn<Task, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        List<TableColumn<Task, ?>> columns = new ArrayList<>();
        columns.add(numberColumn);
        columns.add(taskNameColumn);
        columns.add(statusColumn);

        table.getColumns().addAll(columns);
        table.getItems().addAll(FXCollections.observableArrayList(tasks));

        return table;
    }

    private Region createComboBox() {
        Label statusLabel = new Label("Status:");

        String[] items = {"Open", "Closed", "In Progress", "Pending", "All"};

        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(items));
        comboBox.setVisibleRowCount(5);

        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (oldValue == null) {
                    controller.onValueChangeOccurred(newValue, table, tasks);
                    return;
                }

                if (!oldValue.equals(newValue) && newValue != null) {
                    controller.onValueChangeOccurred(newValue, table, tasks);
                }
            }
        });

        return new HBox(20, statusLabel, comboBox);
    }
}

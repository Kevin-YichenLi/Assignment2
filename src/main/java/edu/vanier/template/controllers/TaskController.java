package edu.vanier.template.controllers;

import edu.vanier.template.models.Status;
import edu.vanier.template.models.Task;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class TaskController {
    public void onValueChangeOccurred(String status, TableView<Task> table, ArrayList<Task> tasks) {
        if (status.equals("All")) {
            table.getItems().clear();
            table.getItems().addAll(FXCollections.observableArrayList(tasks));
            return;
        }

        Status tableStatus = Status.valueOf(toUpperSnakeCase(status));

        ArrayList<Task> localTasks = new ArrayList<>(tasks);

        localTasks.removeIf(currentTask -> currentTask.getStatus() != tableStatus);

        table.getItems().clear();
        table.getItems().addAll(FXCollections.observableArrayList(localTasks));
    }

    private String toUpperSnakeCase(String str) {
        return str.toUpperCase().replace(" ", "_");
    }
}

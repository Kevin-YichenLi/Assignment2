package edu.vanier.template;

import edu.vanier.template.models.Status;
import edu.vanier.template.models.Task;
import edu.vanier.template.views.TaskView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();

        Task task1 = new Task(1, "Fix Bug", Status.OPEN);
        Task task2 = new Task(3, "Contact Vanier College", Status.OPEN);
        Task task3 = new Task(4, "Buy New Books", Status.PENDING);
        Task task4 = new Task(7, "Complete Homeworks", Status.IN_PROGRESS);
        Task task5 = new Task(11, "Eat KFC", Status.CLOSED);
        Task task6 = new Task(21, "Order Pizza",Status.CLOSED);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);

        Scene scene = new Scene(new TaskView(tasks), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tasks List");
        primaryStage.show();
    }
}

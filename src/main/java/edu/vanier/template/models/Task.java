package edu.vanier.template.models;

import edu.vanier.template.controllers.TaskController;

public class Task {
    private int number;
    private String taskName;
    private Status status;

    public Task(int number, String taskName, Status status) {
        this.number = number;
        this.taskName = taskName;
        this.status = status;
    }

    public Task() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

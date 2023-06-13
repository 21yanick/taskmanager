package ch.hftm;

import java.util.ArrayList;
import java.util.List;

public class Taskmanager {
    private List<Task> tasks;

    public Taskmanager() {
        this.tasks = new ArrayList<>();
    }

    public void createTask(String aufgabe, String beschreibung, Priority priority, String datum, Status status) {
        Task task = new Task(aufgabe, beschreibung, priority, datum, status);
        tasks.add(task);
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
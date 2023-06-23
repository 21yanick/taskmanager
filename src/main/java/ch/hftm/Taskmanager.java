package ch.hftm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Taskmanager {
    private List<Task> tasks;

    public Taskmanager() {
        this.tasks = new ArrayList<>();
    }

    public Task createTask(String aufgabe, String beschreibung, Priority priority, LocalDate datum, Status status) {
        Task task = new Task(aufgabe, beschreibung, priority, datum, status);
        tasks.add(task);
        System.out.println("Aufgabe erstellt: " + task.getAufgabe()); // Debug-Ausgabe
        return task;
    }

    public List<Task> getTasks() {
        System.out.println("Anzahl der Aufgaben: " + tasks.size()); // Debug-Ausgabe
        return tasks;
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTask(Task oldTask, Task newTask) {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
        }
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> sucheAufgaben(String schluesselwort) {
        List<Task> gefundeneAufgaben = new ArrayList<>();
        for (Task aufgabe : tasks) {
            if (aufgabe.getAufgabe().contains(schluesselwort) || aufgabe.getBeschreibung().contains(schluesselwort)) {
                gefundeneAufgaben.add(aufgabe);
            }
        }
        return gefundeneAufgaben;
    }
}
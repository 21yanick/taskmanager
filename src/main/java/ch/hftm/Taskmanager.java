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

    public List<Task> filterAufgabenNachStatus(Status status) {
        List<Task> gefilterteAufgabenStatus = new ArrayList<>();
        for (Task aufgabe : tasks) {
            if (aufgabe.getStatus() == status) {
                gefilterteAufgabenStatus.add(aufgabe);
            }
        }
        return gefilterteAufgabenStatus;
    }

    public List<Task> filterAufgabenNachPrioritaet(Priority prioritaet) {
        List<Task> gefilterteAufgabenPrio = new ArrayList<>();
        for (Task aufgabe : tasks) {
            if (aufgabe.getPriority() == prioritaet) {
                gefilterteAufgabenPrio.add(aufgabe);
            }
        }
        return gefilterteAufgabenPrio;
    }

    public void sortiereAufgabenNachDatum() {
        int n = tasks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tasks.get(j).getDatum().compareTo(tasks.get(j + 1).getDatum()) > 0) {
                    // Tausche tasks[j+1] und tasks[j]
                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
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
package ch.hftm;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Taskmanager taskManager = new Taskmanager();
        taskManager.createTask("Task 1", "Beschreibung 1", Priority.HIGH, "13.06.2023", Status.OFFEN);
        taskManager.createTask("Task 2", "Beschreibung 2", Priority.NORMAL, "13.06.2023", Status.ERLEDIGT);
        taskManager.createTask("Task 3", "Beschreibung 3", Priority.LOW, "14.06.2023", Status.OFFEN);
        taskManager.createTask("Task 4", "Beschreibung 4", Priority.HIGH, "15.06.2023", Status.ON_HOLD);

        System.out.println("Alle Aufgaben:");
        taskManager.printTasks();

        System.out.println("\nAufgaben filtern nach Status OFFEN:");
        List<Task> gefilterteAufgabenStatus = taskManager.filterAufgabenNachStatus(Status.OFFEN);
        for (Task task : gefilterteAufgabenStatus) {
            System.out.println(task);
        }

        System.out.println("\nAufgaben filtern nach Priorität HIGH:");
        List<Task> gefilterteAufgabenPrio = taskManager.filterAufgabenNachPrioritaet(Priority.HIGH);
        for (Task task : gefilterteAufgabenPrio) {
            System.out.println(task);
        }

        System.out.println("\nAufgabe suchen:");
        List<Task> gefundeneAufgaben = taskManager.sucheAufgaben("Task 1");
        if (!gefundeneAufgaben.isEmpty()) {
            for (Task task : gefundeneAufgaben) {
                System.out.println(task);
            }
        } else {
            System.out.println("Keine Aufgaben gefunden.");
        }
    }
}

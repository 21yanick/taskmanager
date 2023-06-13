package ch.hftm;

public class App {
    public static void main(String[] args) {
        Taskmanager taskManager = new Taskmanager();
        taskManager.createTask("Task 1", "Beschreibung 1", Priority.HIGH, "13.06.2023", Status.OFFEN);
        taskManager.createTask("Task 2", "Beschreibung 2", Priority.NORMAL, "13.06.2023", Status.ERLEDIGT);
        taskManager.printTasks();
    }
}
package ch.hftm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TaskEditController {

    @FXML
    private TextField aufgabenFeld;
    @FXML
    private TextField beschreibungFeld;
    @FXML
    private DatePicker datumFeld;
    @FXML
    private ChoiceBox<Priority> priorityFeld;
    @FXML
    private ChoiceBox<Status> statusFeld;
    @FXML
    private Button speichernButton;
    @FXML
    private Button abbrechenButton;

    private Taskmanager taskmanager;
    private Task task;

    public TaskEditController(Taskmanager taskmanager) {
        this.taskmanager = taskmanager;
    }

    public TaskEditController() {

    }

    @FXML
    private void initialize() {
        priorityFeld.setItems(FXCollections.observableArrayList(Priority.values()));
        statusFeld.setItems(FXCollections.observableArrayList(Status.values()));

        speichernButton.setOnAction(event -> saveTask());
        abbrechenButton.setOnAction(event -> cancel());
    }

    public void setTask(Task task) {
        this.task = task;
        if (task != null) {
            // Wenn eine Aufgabe übergeben wird, füllen Sie die Felder mit den vorhandenen
            // Daten der Aufgabe
            aufgabenFeld.setText(task.getAufgabe());
            beschreibungFeld.setText(task.getBeschreibung());
            datumFeld.setValue(LocalDate.parse(task.getDatum()));
            priorityFeld.setValue(task.getPriority());
            statusFeld.setValue(task.getStatus());
        } else {
            // Wenn keine Aufgabe übergeben wird, leeren Sie die Felder
            aufgabenFeld.setText("");
            beschreibungFeld.setText("");
            datumFeld.setValue(null);
            priorityFeld.setValue(null);
            statusFeld.setValue(null);
        }
    }

    @FXML
    public void saveTask() {
        String aufgabe = aufgabenFeld.getText();
        String beschreibung = beschreibungFeld.getText();
        String datum = datumFeld.getValue().toString();
        Priority priority = priorityFeld.getValue();
        Status status = statusFeld.getValue();

        if (task == null) {
            // Wenn keine Aufgabe gesetzt wurde, erstellen Sie eine neue Aufgabe
            Task newTask = taskmanager.createTask(aufgabe, beschreibung, priority, datum, status);
        } else {
            // Wenn eine Aufgabe gesetzt wurde, erstellen Sie eine neue Aufgabe mit den
            // aktualisierten Daten
            Task updatedTask = new Task(aufgabe, beschreibung, priority, datum, status);
            // Aktualisieren Sie die Aufgabe in der Liste
            taskmanager.updateTask(task, updatedTask);
        }

        // Schließe das Fenster nach dem Speichern der Aufgabe
        Stage stage = (Stage) speichernButton.getScene().getWindow();
        stage.close();
    }

    private void cancel() {
        // Schließt das Fenster ohne Änderungen zu speichern
        Stage stage = (Stage) abbrechenButton.getScene().getWindow();
        stage.close();
    }

}

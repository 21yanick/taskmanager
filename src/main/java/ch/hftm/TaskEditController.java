package ch.hftm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Optional;

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
    @FXML
    private Button löschenButton;
    @FXML
    private ComboBox<Project> projektFeld;

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
        projektFeld.setItems(FXCollections.observableArrayList(taskmanager.getProjects()));

        speichernButton.setOnAction(event -> saveTask());
        abbrechenButton.setOnAction(event -> cancel());
        löschenButton.setOnAction(event -> deleteTask());
    }

    public void setTask(Task task) {
        this.task = task;
        if (task != null) {
            aufgabenFeld.setText(task.getAufgabe());
            beschreibungFeld.setText(task.getBeschreibung());
            datumFeld.setValue((task.getDatum()));
            priorityFeld.setValue(task.getPriority());
            statusFeld.setValue(task.getStatus());
            projektFeld.setValue(task.getProject());
        } else {
            aufgabenFeld.setText("");
            beschreibungFeld.setText("");
            datumFeld.setValue(null);
            priorityFeld.setValue(null);
            statusFeld.setValue(null);
            projektFeld.setValue(null);

        }
    }

    @FXML
    public void saveTask() {
        String aufgabe = aufgabenFeld.getText();
        String beschreibung = beschreibungFeld.getText();
        LocalDate datum = datumFeld.getValue();
        Priority priority = priorityFeld.getValue();
        Status status = statusFeld.getValue();
        Project project = projektFeld.getValue();

        if (task == null) {
            Task newTask = taskmanager.createTask(aufgabe, beschreibung, priority, datum, status, project);
        } else {
            Task updatedTask = new Task(aufgabe, beschreibung, priority, datum, status, project);
            taskmanager.updateTask(task, updatedTask);
        }

        Stage stage = (Stage) speichernButton.getScene().getWindow();
        stage.close();
    }

    private void cancel() {
        Stage stage = (Stage) abbrechenButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deleteTask() {
        if (task != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aufgabe löschen");
            alert.setHeaderText("Bist du sicher, dass du die Aufgabe löschen möchtest?");
            alert.setContentText("Dies kann nicht rückgängig gemacht werden.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                taskmanager.deleteTask(task);
                Stage stage = (Stage) löschenButton.getScene().getWindow();
                stage.close();
            }
        }
    }

    @FXML
    public void createProject() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Neues Projekt");
        dialog.setHeaderText("Gib den Namen des neuen Projekts ein:");
        dialog.setContentText("Name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            taskmanager.createProject(result.get());
            projektFeld.setItems(FXCollections.observableArrayList(taskmanager.getProjects()));
        }
    }

    @FXML
    public void deleteProject() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Projekt löschen");
        alert.setHeaderText("Bist du sicher, dass du das Projekt löschen möchtest?");
        alert.setContentText("Projekt: " + projektFeld.getValue().getProjectName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            taskmanager.deleteProject(projektFeld.getValue());
            projektFeld.setItems(FXCollections.observableArrayList(taskmanager.getProjects()));
        }
    }

}

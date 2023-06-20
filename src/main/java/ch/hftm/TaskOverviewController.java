package ch.hftm;

import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TaskOverviewController {

    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> titleColumn;
    @FXML
    private TableColumn<Task, String> descriptionColumn;
    @FXML
    private TableColumn<Task, String> priorityColumn;
    @FXML
    private TableColumn<Task, String> dueDateColumn;
    @FXML
    private TableColumn<Task, String> statusColumn;
    @FXML
    private Button AufgabeHinzufügenButton;
    @FXML
    private Button AufgabeBearbeitenButton;
    @FXML
    private TextField SuchenFeld;

    private Taskmanager taskmanager;

    public TaskOverviewController(Taskmanager taskmanager) {
        this.taskmanager = taskmanager;
    }

    public TaskOverviewController() {
    }

    @FXML
    private void initialize() {

        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAufgabe()));
        descriptionColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBeschreibung()));
        priorityColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getPriority().toString()));
        dueDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDatum()));
        statusColumn
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));

        taskTable.setItems(FXCollections.observableArrayList(taskmanager.getTasks()));

        SuchenFeld.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                searchTasks();
            }
        });
    }

    public void setTaskmanager(Taskmanager taskmanager) {
        this.taskmanager = taskmanager;
    }

    @FXML
    private void aktualisieren() {
        taskTable.getItems().setAll(taskmanager.getTasks());
    }

    @FXML
    private void addTask() {
        showTaskEditDialog(null);
    }

    @FXML
    private void editTask() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            showTaskEditDialog(selectedTask);
        } else {
            // Zeigen Sie eine Nachricht an, wenn keine Aufgabe ausgewählt wurde
            System.out.println("Keine Aufgabe ausgewählt.");
        }
    }

    private void showTaskEditDialog(Task task) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("resources/task_edit.fxml"));
            loader.setController(new TaskEditController(taskmanager));
            Parent root = loader.load();

            TaskEditController controller = loader.getController();
            controller.setTask(task);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Nachdem das Fenster geschlossen wurde, aktualisieren Sie die TableView
            taskTable.getItems().setAll(taskmanager.getTasks());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchTasks() {
        String keyword = SuchenFeld.getText();
        ObservableList<Task> filteredTasks = FXCollections.observableArrayList(taskmanager.sucheAufgaben(keyword));
        taskTable.setItems(filteredTasks);
    }
}
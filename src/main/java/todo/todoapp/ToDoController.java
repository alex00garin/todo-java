package todo.todoapp;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;


public class ToDoController {
    @FXML
    private TextField taskInputField;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private Button editButton;

    public ToDoController() {
    }

    @FXML
    private void addTask() {
        String taskText = taskInputField.getText();
        if (!taskText.isEmpty()) {
            taskListView.getItems().add(taskText);
            taskInputField.clear();

        }
        taskInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addTask();
            }
        });
    }
    @FXML
    private void deleteTask() {
        taskListView.getItems().remove(taskListView.getSelectionModel().getSelectedIndex());
        taskListView.getSelectionModel().clearSelection();
    }

    @FXML
    private void editTask() {
        if (editButton.getText().equals("Edit")) {
            editButton.setDisable(true);
            taskInputField.setDisable(false);
            taskInputField.setText(taskListView.getSelectionModel().getSelectedItem());
        }

        // Wait for the user to finish editing the task
        taskInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                confirmTask();
            }
        });

        editButton.setOnAction(event -> {
            confirmTask();
        });
    }

    private void confirmTask() {
        String taskText = taskInputField.getText();
        if (!taskText.isEmpty()) {
            taskListView.getItems().set(taskListView.getSelectionModel().getSelectedIndex(), taskText);
            taskInputField.clear();
            editButton.setDisable(false);
        }
    }
}



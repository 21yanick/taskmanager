package ch.hftm;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private List<Task> tasks;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    @Override
    public String toString() {
        return this.getProjectName();
    }

}

package ch.hftm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Taskmanager {
    private List<Task> tasks;
    private List<Project> projects;

    public Taskmanager() {
        this.tasks = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public Task createTask(String aufgabe, String beschreibung, Priority priority, LocalDate datum, Status status, Project project) {
        Task task = new Task(aufgabe, beschreibung, priority, datum, status, project);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
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

    public Project createProject(String name) {
        Project project = new Project(name);
        projects.add(project);
        return project;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }
}

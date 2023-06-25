package ch.hftm;

import java.time.LocalDate;

public class Task {
    private String aufgabe;
    private String beschreibung;
    private Priority priority;
    private LocalDate datum;
    private Status status;
    private Project project;

    public Task(String aufgabe, String beschreibung, Priority priority, LocalDate datum, Status status, Project project) {
        this.aufgabe = aufgabe;
        this.beschreibung = beschreibung;
        this.priority = priority;
        this.status = status;
        this.datum = datum;
        this.project = project;
    }

    
    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Aufgabe='" + aufgabe + '\'' +
                ", Beschreibung='" + beschreibung + '\'' +
                ", Priority=" + priority +
                ", Status=" + status +
                ", Erstelldatum=" + datum +
                ", Project=" + project.getProjectName() +
                '}';
    }
}
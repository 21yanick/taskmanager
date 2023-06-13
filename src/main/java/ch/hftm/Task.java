package ch.hftm;

public class Task {
    private String aufgabe;
    private String beschreibung;
    private Priority priority;
    private String datum;
    private Status status;

    
    public Task(String aufgabe, String beschreibung, Priority priority, String datum, Status status) {
        this.aufgabe = aufgabe;
        this.beschreibung = beschreibung;
        this.priority = priority;
        this.status = status;
        this.datum = datum;
    }

    
    // Getter und Setter Methoden
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Aufgabe='" + aufgabe + '\'' +
                ", Beschreibung='" + beschreibung + '\'' +
                ", Priority=" + priority +
                ", Status=" + status +
                ", Erstelldatum=" + datum +
                '}';
    }    
}

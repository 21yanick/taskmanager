package ch.hftm;

public enum Status {
    ERLEDIGT,
    OFFEN,
    ON_HOLD;

    @Override
    public String toString() {
        switch(this) {
            case ERLEDIGT: return "Erledigt";
            case OFFEN: return "Offen";
            case ON_HOLD: return "On Hold";
            default: throw new IllegalArgumentException();
        }
    }
}
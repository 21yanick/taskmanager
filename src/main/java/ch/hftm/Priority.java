package ch.hftm;

public enum Priority {
    HIGH,
    NORMAL,
    LOW;

    @Override
    public String toString() {
        switch(this) {
            case HIGH: return "Hoch";
            case NORMAL: return "Normal";
            case LOW: return "Niedrig";
            default: throw new IllegalArgumentException();
        }
    }
}
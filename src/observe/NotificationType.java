package observe;

public enum NotificationType {
    ADD("ADD"),
    REMOVE("REMOVE"),
    MODIFY("MODIFY");

    private String label;
    private NotificationType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

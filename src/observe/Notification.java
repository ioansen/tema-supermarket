package observe;

import java.time.LocalDateTime;

public class Notification {

    private final LocalDateTime cretedOn;
    private final long departmentId;
    private final long itemId;
    private final NotificationType type;

    private Notification(LocalDateTime cretedOn, long departmentId, long itemId, NotificationType type) {
        this.cretedOn = cretedOn;
        this.departmentId = departmentId;
        this.itemId = itemId;
        this.type = type;
    }

    public static Notification spawn(long departmentId, long itemId, NotificationType type){
        return new Notification(LocalDateTime.now(),  departmentId, itemId, type);
    }

    public LocalDateTime getCretedOn() {
        return cretedOn;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public long getItemId() {
        return itemId;
    }

    public NotificationType getType() {
        return type;
    }
}

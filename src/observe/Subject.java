package observe;

import java.util.List;
import java.util.Set;

/**
 * This class represents an observable object.
 * It can be subclassed to represent an object that the application wants to have observed.
 *
 * @see Observer
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    /**
     */
    void notifyAllObservers(Notification notification);

    List<Observer> getObservers();

}

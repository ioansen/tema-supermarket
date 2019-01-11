package events;

import model.AbstractDepartment;
import model.Department;
import model.Store;

public class GetObserversEvent implements Event {

    private final int depId;

    public GetObserversEvent(int depId) {
        this.depId = depId;
    }

    @Override
    public void fire() {
        Department department = Store.getInstance().getDepartment(depId);
        System.out.println(department.getObservers());
    }
}

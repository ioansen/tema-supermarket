import model.Customer;
import model.Department;
import model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static Store STORE = null;

    private String name;
    private List<Customer> customers;
    private List<Department> departments;

    private Store(String name) {
        this.name = name;
        customers = new ArrayList<>();
        departments = new ArrayList<>();
    }

    public static Store getInstance() {
        if (STORE == null) {
            STORE = new Store("SHOP");
        }
        return STORE;
    }

    public void enter(Customer customer){
        customers.add(customer);
    }

    public void exit(Customer customer){
        customers.remove(customer);
    }

    public static ShoppingCart getShoppingCart(Double budget){
        return new ShoppingCart(budget);
    }


    public void addDepartment(Department department){
        departments.add(department);
    }

    public List<Department> getDepartments(){
        return departments;
    }

    public Department getDepartment(Integer id){
        for (Department department : departments){
            if (department.getId() == id)
                return department;
        }
        return null;
    }
}



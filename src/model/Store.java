package model;

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

    /*name is silly here cuz it'll only work the first time but w/e*/
    public static Store getInstance(String name) {
        if (STORE == null) {
            STORE = new Store(name);
        }
        return STORE;
    }

    /*this is even more dumb, but w/e*/
    public static Store getInstance() {
        if (STORE == null) {
            throw new AssertionError(
                    "Store wasn't initialized. " +
                            "Call getInstance(String) to instantiate one");
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

    public Customer getCustomer(String customerName){
        for ( Customer customer : customers){
            if (customerName.equals(customer.getName())){
                return customer;
            }
        }
        return null;
    }

    public void addDepartment(Department department){
        departments.add(department);
    }

    public List<Department> getDepartments(){
        return departments;
    }

    public  List<Customer> getCustomers(){
        return getCustomers();
    }

    public Department getDepartment(Integer id){
        for (Department department : departments){
            if (department.getId() == id)
                return department;
        }
        return null;
    }
}



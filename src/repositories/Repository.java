package repositories;

import model.WithId;

import java.util.List;

public interface Repository<T extends WithId> {

    void save(T t);

    T delete(int id);

    void delete(T t);

    T find(int id);

    List<T> findAll();

}

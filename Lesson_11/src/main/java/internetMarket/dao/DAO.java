package internetMarket.dao;

import java.util.List;

public interface DAO<T> {

    T findById(int id);

    List<T> findAll();

    void create(T model);

    void update(T model);

    void deleteById(int id);
}

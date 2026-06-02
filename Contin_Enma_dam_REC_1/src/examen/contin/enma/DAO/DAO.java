package examen.contin.enma.DAO;

import java.util.List;

public interface DAO<T> {
    List<T> findAll();
    T findById(int id);
    void add(T bean);
    void update(T bean);
    void delete(int id);

}

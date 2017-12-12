package andersen.dao;

import andersen.model.Id;

public interface CrudDAO<T extends Id> {

    void create(T entity);

    T read(Long id);

    void update(T entity);

    void delete(Long id);

}

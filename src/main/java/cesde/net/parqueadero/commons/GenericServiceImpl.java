package cesde.net.parqueadero.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);

        if (obj.isEmpty()) {
            return null;
        }
        return obj.get();
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();

        getDao().findAll().forEach(list::add);

        return list;
    }

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    public abstract CrudRepository<T, ID> getDao();
}

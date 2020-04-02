package dao;

import java.io.Serializable;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public interface IDAO<T> {

    public T create(T object);

    public T read(Serializable key);

    public void update(T object);

    public void delete(T object);

}

package dto.mappers;

/**
 *
 * @author jeff
 * @param <T> Internal object type
 * @param <K> DTO object type
 */
public interface Mapper<T, K> {

    public K fromInternal(T object);

    public T toInternal(K object);
}

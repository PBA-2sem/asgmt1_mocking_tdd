package DTOs;

public interface JSONDTO<T> {
    /**
     * Converts to internal ORM object
     * @return provided enitity object
     */
    public T toInternal();
}

package dev.juanim.movies_api.implementations;

/* No separo más en CRUD por innecesario. */

public interface InterfaceGenericWriteService<T> {

    public T create(T entity);

    public T update(Long id, T entity);

    public void delete(Long id);
}
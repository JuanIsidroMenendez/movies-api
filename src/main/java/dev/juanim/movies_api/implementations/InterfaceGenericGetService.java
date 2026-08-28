package dev.juanim.movies_api.implementations;

import java.util.List;

/* Corrección: No se pueden meter los CRUD en una misma infertaz
porque incumpliría segregación de interfaces (I) */

public interface InterfaceGenericGetService<T> {

    public List<T> getEntities();

    public T getById(Long id);
}
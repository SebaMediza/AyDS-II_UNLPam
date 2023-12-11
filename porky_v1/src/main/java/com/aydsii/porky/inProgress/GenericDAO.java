package com.aydsii.porky.inProgress;

import java.io.Serializable;
import java.util.List;

import org.checkerframework.checker.units.qual.K;

public abstract class GenericDAO <K extends Serializable, T> {
    protected Object connection;

    public GenericDAO(Object connection){
        this.connection = connection;
    }

    public abstract K create(T model);
    public abstract List<T> getAll();
    public abstract T getById(K id);
    public abstract void update(K id,T model);
    public abstract void delete(K id);
}

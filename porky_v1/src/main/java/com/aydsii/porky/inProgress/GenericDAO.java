package com.aydsii.porky.inProgress;

import java.io.Serializable;
import java.util.List;

import org.checkerframework.checker.units.qual.K;

public interface GenericDAO<K extends Serializable, T> 
{
    public K create(T value);
    public List<T> getAll();
    public T getById(K id);
    public void update(K id,T value);
    public void delete(T value);
}

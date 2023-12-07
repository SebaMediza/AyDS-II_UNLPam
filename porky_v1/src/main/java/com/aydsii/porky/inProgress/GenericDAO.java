package com.aydsii.porky.inProgress;

import java.io.Serializable;
import java.util.List;

import org.checkerframework.checker.units.qual.K;

public interface GenericDAO<K extends Serializable, T> 
{
    public T find(K id);
    public List<T> find();
    public K save(T value);
    public void update(T value);
    public void delete(T value);
}

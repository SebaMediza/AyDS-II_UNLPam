package com.aydsii.porky.inProgress;

import java.io.IOException;
import java.io.Serializable;

public interface AbstractFactory {
    Object getConnection()throws IOException;

    <K extends Serializable, T> GenericDAO<K, T> getDAO(Class<T> entityType);
}

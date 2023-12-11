package com.aydsii.porky.inProgress;

import java.io.IOException;
import java.io.Serializable;

public interface AbstractFactory {
    //Será necesario un casteo a la clase correspondiente al llamar la función
    public Object getConnection() throws IOException;

    <K extends Serializable, T> GenericDAO<K, T> getDAO(Class<T> model);
}

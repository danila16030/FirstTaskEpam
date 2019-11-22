package main.com.epam.firsttask.registrar;

import main.com.epam.firsttask.entity.Figure;

public interface Registrar<E> {
    void update(E e);
}

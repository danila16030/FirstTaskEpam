package main.com.epam.firsttask.action.figure;

public interface Action<R, E> {
    public R execute(E e);
}

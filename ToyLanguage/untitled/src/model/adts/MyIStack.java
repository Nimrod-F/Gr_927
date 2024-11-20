package model.adts;

import exceptions.EmptyStackException;

public interface MyIStack<T> {

    void push(T elem);

    T pop() throws EmptyStackException;

    boolean isEmpty();

}

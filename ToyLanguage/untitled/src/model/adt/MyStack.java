package model.adt;

import exceptions.EmptyStackException;

import java.util.Stack;

public class MyStack<T> implements MyIStack<T>{
    private Stack<T> stack;

    public MyStack()
    {
        this.stack = new Stack<>();
    }

    public Stack<T> getStack() {
        return stack;
    }

    @Override
    public void push(T element) {
        this.stack.push(element);
    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.stack.isEmpty())
            throw new EmptyStackException("Stack is empty");
        return this.stack.pop();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(T element: this.stack){
            str.append(element).append("\n");
        }
        return "MyStack contains " + str;
    }
}

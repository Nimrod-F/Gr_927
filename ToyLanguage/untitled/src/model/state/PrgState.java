package model.state;

import model.adt.MyIDictionary;
import model.statements.IStatement;
import model.value.IValue;
import model.adt.MyIStack;
import model.adt.MyIList;

public class PrgState {
    private MyIDictionary<String, IValue> symTable;
    private MyIStack<IStatement> exeStack;
    private MyIList<String> output;


    public PrgState(MyIDictionary<String, IValue> symTable , MyIStack<IStatement> exeStack, MyIList<String> output , IStatement initialState) {
        this.symTable = symTable;
        this.exeStack = exeStack;
        this.output = output;
        this.exeStack.push(initialState);
    }






}

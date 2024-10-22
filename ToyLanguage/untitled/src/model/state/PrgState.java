package model.state;

import model.adt.MyIDictionary;
import model.statements.IStatement;
import model.value.IValue;
import model.adt.MyIStack;
import model.adt.MyIList;

public class PrgState {
    private MyIDictionary<String, IValue> symTable;

    public MyIDictionary<String, IValue> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, IValue> symTable) {
        this.symTable = symTable;
    }

    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    private MyIStack<IStatement> exeStack;
    private MyIList<String> output;


    public PrgState(MyIDictionary<String, IValue> symTable , MyIStack<IStatement> exeStack, MyIList<String> output , IStatement initialState) {
        this.symTable = symTable;
        this.exeStack = exeStack;
        this.output = output;
        this.exeStack.push(initialState);
    }


    public MyIList<String> getOutput() {
        return output;
    }

    public void setOutput(MyIList<String> output) {
        this.output = output;
    }
    public String toString(){
        return symTable.toString() + " " + exeStack.toString() + " " + output.toString();
    }
}

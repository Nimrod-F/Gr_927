package model.state;
import java.io.BufferedReader;

import model.adt.MyIDictionary;
import model.statements.IStatement;
import model.value.IValue;
import model.adt.MyIStack;
import model.adt.MyIList;
import model.value.StringValue;

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
    private IStatement initialState;

    private MyIDictionary<StringValue, BufferedReader> fileTable;

    public PrgState(MyIDictionary<String, IValue> symTable ,
                    MyIStack<IStatement> exeStack,
                    MyIList<String> output ,
                    IStatement initialState,
                    MyIDictionary<StringValue,
                            BufferedReader> fileTable) {
        this.symTable = symTable;
        this.exeStack = exeStack;
        this.output = output;
        this.initialState = initialState.deepCopy();
        this.exeStack.push(this.initialState);
        this.fileTable = fileTable;
    }

    public MyIDictionary<StringValue, BufferedReader> getFileTable(){
        return this.fileTable;
    }

    public String fileTableToString() {
        StringBuilder text = new StringBuilder();
        text.append("FileTable: \n");
        for(StringValue key : this.fileTable.getKeys()) {
            text.append(key).append("\n");
        }
        return text.toString();
    }

    public MyIList<String> getOutput() {
        return output;
    }

    public void setOutput(MyIList<String> output) {
        this.output = output;
    }
    public String toString(){
        return symTable.toString() + "\n" + exeStack.toString() + "\n" + output.toString() + "\n" + fileTableToString() + "\n";
    }
}

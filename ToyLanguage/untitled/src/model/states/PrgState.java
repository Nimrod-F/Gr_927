package model.states;

import model.adts.*;
import model.statements.IStatement;
import model.values.IValue;
import model.values.StringValue;

import java.io.BufferedReader;

public class PrgState {

    private MyIStack<IStatement> execStack;
    private MyIMap<String, IValue> symTable;
    private MyIList<String> outputList;
    private IStatement initialState;
    private MyIMap<StringValue, BufferedReader> fileTable;
    private MyIHeap heap;

    public PrgState(IStatement initState, MyIStack<IStatement> execStack, MyIMap<String, IValue> symTable,
                    MyIList<String> outputList, MyIHeap heap) {
        this.execStack = execStack;
        this.symTable = symTable;
        this.outputList = outputList;
        this.initialState = initState.deepCopy();
        this.execStack.push(this.initialState);
        this.fileTable = new MyMap<>();
        this.heap = heap;

    }

    public MyIStack<IStatement> getExecStack() {
        return this.execStack;
    }

    public MyIMap<String, IValue> getSymTable() {
        return this.symTable;
    }

    public MyIList<String> getOutputList() {
        return this.outputList;
    }

    public MyIMap<StringValue, BufferedReader> getFileTable() {
        return fileTable;
    }

    public MyIHeap getHeap(){
        return heap;
    }

    public void setExecStack(MyIStack<IStatement> execStack) {
        this.execStack = execStack;
    }

    public void setSymTable(MyIMap<String, IValue> symTable) {
        this.symTable = symTable;
    }

    public void setOutputList(MyIList<String> outputList) {
        this.outputList = outputList;
    }

    public void setHeap(MyIHeap heap){
        this.heap = heap;
    }


    private String fileTableToString(){
        StringBuilder str = new StringBuilder();
        for (StringValue key : this.getFileTable().getKeys()) {
            str.append(key).append("\n");
        }
        return "FileTable:\n" + str;
    }


    @Override
    public String toString() {
        return this.execStack.toString() + '\n' + this.symTable.toString() + '\n' +
                this.outputList.toString() + '\n' + fileTableToString() + '\n' + this.heap.toString() + '\n';
    }

}

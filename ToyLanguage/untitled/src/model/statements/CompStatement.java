package model.statements;

import exceptions.ADTException;
import exceptions.StatementException;
import model.state.PrgState;

public class CompStatement implements IStatement{
    private IStatement statement1;
    private IStatement statement2;

    public CompStatement(IStatement statement1, IStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    @Override
    public PrgState execute(PrgState prgState) throws StatementException, ADTException {
        prgState.getExeStack().push(statement2);
        prgState.getExeStack().push(statement1);

        return prgState;
    }

    @Override
    public IStatement deepCopy() {
        return new CompStatement(this.statement1, this.statement2);
    }

    @Override
    public String toString() {
        return statement1.toString() + ";" + statement2.toString();
    }

}
